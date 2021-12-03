package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

public class Tester extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        Test.class,
                        message -> sender().tell(
                                runTest(message),
                                self()
                        )
                )
                .build();
    }

    private TestResult runTest(Test test) {
        
    }
}
