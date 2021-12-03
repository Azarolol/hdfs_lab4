package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    private final String testName;
    private final String jsScript;
    private final String expectedResult;
    private final List<Object> params;

    @JsonCreator
    public Test(@JsonProperty("testName") String testName,
                @JsonProperty("jsScript") String jsScript,
                @JsonProperty("expectedResult") String expectedResult,
                @JsonProperty("params") List<Object> params) {
        this.testName = testName;
        this.jsScript = jsScript;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getTestName() {
        return testName;
    }

    public String getJsScript() {
        return jsScript;
    }

    public List<Object> getParams() {
        return params;
    }
}
