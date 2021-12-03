package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

public class Keeper extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResult.class,
                        message -> 
                )
    }
}
