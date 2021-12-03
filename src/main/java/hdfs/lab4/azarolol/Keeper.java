package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

import java.util.*;

public class Keeper extends AbstractActor {
    private Map<String, List<TestResult>> storage = new HashMap<>();
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResultWithID.class,
                        this::storeResult
                )
                .match(
                        GetResultMessage.class,
                        
                )
    }

    private void storeResult(TestResultWithID result) {
        String packageID = result.getPackageID();
        if (storage.containsKey(packageID)) {
            storage.get(packageID).add(result.getTestResult());
        } else {
            storage.put(packageID,
                    new ArrayList<>(Collections.singletonList(result.getTestResult())));
        }
    }
}
