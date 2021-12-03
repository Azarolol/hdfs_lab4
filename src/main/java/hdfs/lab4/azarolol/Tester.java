package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

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

    private parseJS (Test test) {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName(ENGINE_NAME);
        engine.eval()
    }

    private TestResult runTest(Test test) {

    }
}
