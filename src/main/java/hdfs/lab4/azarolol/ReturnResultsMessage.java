package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReturnResultsMessage {
    private final String packageID;
    private final List<TestResult> testResult;

    @JsonCreator
    public ReturnResultsMessage(@JsonProperty("packageId") String packageID,
                                @JsonProperty ("testResult") List<TestResult> testResult) {
        this.packageID = packageID;
        this.testResult = testResult;
    }

    public String getPackageID() {
        return packageID;
    }

    public List<TestResult> getTestResult () {
        return testResult;
    }
}
