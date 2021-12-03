package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Router;

public class Guide extends AbstractActor {
    ActorRef keeper = getContext().actorOf(Props.create(Keeper.class));
    Router router = new Router(new RoundRobinRoutingLogic());
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestPackageMessage.class,
                        message -> {
                            for (Test test: message.getTests()) {

                            }
                        }
                )
    }
}
