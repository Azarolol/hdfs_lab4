package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TestResult {
    private final String testName;
    private final boolean passed;
    private final String expectedResult;
    private final String receivedResult;

    @JsonCreator
    public TestResult(@JsonProperty("testName") String testName,
                      @JsonProperty("ifPassed") boolean ifPassed,
                      @JsonProperty ("expectedResult") String expectedResult,
                      @JsonProperty("receivedResult") String receivedResult) {
        this.testName = testName;
        this.passed = Objects.equals(expectedResult, receivedResult);
        this.expectedResult = expectedResult;
        this.receivedResult = receivedResult;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getReceivedResult() {
        return receivedResult;
    }
}
