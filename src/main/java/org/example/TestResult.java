package org.example;

import java.util.Date;

public class TestResult {
    private int totalTests;
    private int succeededTests;
    private int failedTests;
    private long executionTime;
    private Date startTime;

    public TestResult(int totalTests, int succeededTests, int failedTests, long executionTime, Date startTime) {
        this.totalTests = totalTests;
        this.succeededTests = succeededTests;
        this.failedTests = failedTests;
        this.executionTime = executionTime;
        this.startTime = startTime;
    }

    public int getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(int totalTests) {
        this.totalTests = totalTests;
    }

    public int getSucceededTests() {
        return succeededTests;
    }

    public void setSucceededTests(int succeededTests) {
        this.succeededTests = succeededTests;
    }

    public int getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "totalTests=" + totalTests +
                ", succeededTests=" + succeededTests +
                ", failedTests=" + failedTests +
                ", executionTime=" + executionTime +
                ", startTime=" + startTime +
                '}';
    }
}
