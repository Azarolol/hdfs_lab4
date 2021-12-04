package hdfs.lab4.azarolol;

import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Tester extends AbstractActor {
    final static String ENGINE_NAME = "nashorn";
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

    private String parseJS(Test test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new
                ScriptEngineManager().getEngineByName(ENGINE_NAME);
        engine.eval(test.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(test.getFunctionName(), test.getParams()).toString();
    }

    private TestResultWithID runTest(Test test) throws ScriptException, NoSuchMethodException {
        return new TestResultWithID(
                test.getPackageID(),
                new TestResult(
                    test.getTestName(),
                    test.getExpectedResult(),
                    parseJS(test)
                )
        );
    }
}
