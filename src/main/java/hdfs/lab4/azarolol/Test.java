package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private final String testName;
    private final String expectedResult;
    private final Object[] params;

    @JsonCreator
    public Test(@JsonProperty("testName") String testName,
                @JsonProperty("expectedResult") String expectedResult,
                @JsonProperty("params") Object[] params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getTestName() {
        return testName;
    }

    public Object[] getParams() {
        return params;
    }
}
