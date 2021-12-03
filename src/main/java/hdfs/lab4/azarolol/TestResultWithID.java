package hdfs.lab4.azarolol;


public class TestResultWithID {
    private final String packageID;
    private final TestResult testResult;


    public TestResultWithID(String packageID, TestResult testResult) {
        this.packageID = packageID;
        this.testResult = testResult;
    }

    public String getPackageID() {
        return packageID;
    }

    public TestResult getTestResultList () {
        return testResult;
    }
}
