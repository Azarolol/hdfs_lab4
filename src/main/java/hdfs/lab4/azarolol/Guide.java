package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;
import java.util.List;

public class Guide extends AbstractActor {
    private final Router router;
    private final ActorRef keeper;
    public Guide(String STRING_NUMBER_OF_TESTERS) {
        List<Routee> routes= new ArrayList<>();
        final int NUMBER_OF_TESTERS = Integer.parseInt(STRING_NUMBER_OF_TESTERS);
        for (int i = 0; i < NUMBER_OF_TESTERS; i++) {
            ActorRef tester = getContext().actorOf(Props.create(Tester.class));
            routes.add(new ActorRefRoutee(tester));
        }
        keeper = getContext().actorOf(Props.create(Keeper.class));
        router = new Router(new RoundRobinRoutingLogic(), routes);
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestPackageMessage.class,
                        message -> {
                            for (Test test: message.getTests()) {
                                router.route(test, keeper);
                            }
                        }
                )
                .match(
                        GetResultMessage.class,
                        message -> keeper.tell(message, sender())
                )
                .build();
    }
}
