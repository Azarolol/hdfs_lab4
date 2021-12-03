package hdfs.lab4.azarolol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPackageMessage {
    private final String packageID;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public TestPackageMessage(
            @JsonProperty("packageId") String packageID,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("functionName") String functionName,
            @JsonProperty("tests") Test[] tests) {
        this.packageID = packageID;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public String getPackageID() {
        return packageID;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Test[] getTests() {
        return tests;
    }
}
