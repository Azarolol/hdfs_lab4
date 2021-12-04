package hdfs.lab4.azarolol;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import scala.concurrent.Future;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static akka.http.javadsl.server.Directives.*;

public class JSTester {
    final static String ACTOR_SYSTEM_NAME = "ActorsRoutes";
    final static String HOST = "localhost";
    final static int PORT = 8080;
    final static String WELCOME_MESSAGE = "Server online at http://" + HOST + ":" + PORT + "/\nPress RETURN to stop...";
    final static String TEST_STARTED_MESSAGE = "Test started!";
    final static String TEST_SEGMENT = "test";
    final static String RESULT_SEGMENT = "result";
    final static String NUMBER_OF_TESTERS = "3";
    public static void main (String[] args) throws IOException {
        ActorSystem system = ActorSystem.create(ACTOR_SYSTEM_NAME);
        ActorRef guide = system.actorOf(Props.create(Guide.class), NUMBER_OF_TESTERS);
        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        JSTester instance = new JSTester();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.createRoute(guide).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(HOST, PORT),
                materializer
        );
        System.out.println(WELCOME_MESSAGE);
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }

    private Route createRoute(ActorRef guide) {
        return route(
                path(TEST_SEGMENT, () ->
                        route(
                            post(() ->
                                entity(Jackson.unmarshaller(TestPackageMessage.class), msg -> {
                                    guide.tell(msg, ActorRef.noSender());
                                    return complete(TEST_STARTED_MESSAGE);
                                })))),
                path(RESULT_SEGMENT, () ->
                        route(
                                get(
                                        () -> parameter("packageId",
                                                (id) -> {
                                            Future<Object> result = Patterns.ask(
                                                    guide,
                                                    new GetResultMessage(id),
                                                    5000
                                            );
                                            return completeOKWithFuture(result, Jackson.marshaller());
                                        })
                                )
                        )
                )
        );
    }
}