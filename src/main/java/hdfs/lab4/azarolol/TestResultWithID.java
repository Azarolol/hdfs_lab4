package hdfs.lab4.azarolol;

import java.util.ArrayList;
import java.util.List;

public class TestResults {
    private final String packageID;
    private final List<TestResult> testResultList;


    public TestResults(String packageID) {
        this.packageID = packageID;
        this.testResultList = new ArrayList<>();
    }

    public String getPackageID() {
        return packageID;
    }

    public List<TestResult> getTestResultList () {
        return testResultList;
    }

    public void addResult(TestResult result) {
        this.testResultList.add(result);
    }
}
