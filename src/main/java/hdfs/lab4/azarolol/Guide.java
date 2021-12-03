package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;
import akka.routing.Router;

public class Guide extends AbstractActor {
    Router router = new Router(Rou)
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
