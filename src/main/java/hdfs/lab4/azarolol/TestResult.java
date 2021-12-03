package hdfs.lab4.azarolol;

public class TestResult {
    private final String testName;
    private final String expectedResult;
    private final String receivedResult;


    public TestResult(String testName, String expectedResult, String receivedResult) {
        this.testName = testName;
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
