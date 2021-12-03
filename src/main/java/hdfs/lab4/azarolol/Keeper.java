package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

import java.util.List;
import java.util.Map;

public class Keeper extends AbstractActor {
    private Map<String, List<TestResult>> 
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResultWithID.class,
                        this::storeResult
                )
    }

    private void storeResult(TestResultWithID result) {
        String packageID = result.getPackageID();

    }
}
