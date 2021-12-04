package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

import java.util.*;

public class Keeper extends AbstractActor {
    private final Map<String, List<TestResult>> storage = new HashMap<>();
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResult.class,
                        this::storeResult
                )
                .match(
                        GetResultMessage.class,
                        message -> sender().tell(
                                new ReturnResultsMessage(
                                        message.getPackageID(),
                                        storage.get(message.getPackageID())
                                ),
                                self()
                        )
                )
                .build();
    }

    private void storeResult(TestResultWi result) {
        String packageID = result.getPackageID();
        if (storage.containsKey(packageID)) {
            storage.get(packageID).add(result.getTestResult());
        } else {
            storage.put(packageID,
                    new ArrayList<>(Collections.singletonList(result.getTestResult())));
        }
    }
}
