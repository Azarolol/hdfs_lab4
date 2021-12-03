package hdfs.lab4.azarolol;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResultWithID {
    private final String packageID;
    private final TestResult testResult;

    @JsonCreator
    public TestResultWithID(@JsonProperty ("packageId") String packageID,
                            @JsonProperty ("testResult") TestResult testResult) {
        this.packageID = packageID;
        this.testResult = testResult;
    }

    public String getPackageID() {
        return packageID;
    }

    public TestResult getTestResult () {
        return testResult;
    }
}
