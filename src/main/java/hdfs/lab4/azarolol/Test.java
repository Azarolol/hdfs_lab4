package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Test {
    private final String packageID;
    private final String testName;
    private final String functionName;
    private final String jsScript;
    private final String expectedResult;
    private final List<Object> params;

    @JsonCreator
    public Test(@JsonProperty("packageId") String packageID,
                @JsonProperty("testName") String testName,
                @JsonProperty("functionName") String functionName,
                @JsonProperty("jsScript") String jsScript,
                @JsonProperty("expectedResult") String expectedResult,
                @JsonProperty("params") List<Object> params) {
        this.packageID = packageID;
        this.testName = testName;
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getPackageID() {
        return packageID;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getTestName() {
        return testName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getJsScript() {
        return jsScript;
    }

    public List<Object> getParams() {
        return params;
    }
}
