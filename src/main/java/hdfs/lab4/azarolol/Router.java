package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

public class Router extends AbstractActor {

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