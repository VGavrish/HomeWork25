package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestResultParser {
    public static TestResult parse(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int totalTests = 0;
            int succeededTests = 0;
            int failedTests = 0;
            long executionTime = 0;

            Pattern totalTestsPattern = Pattern.compile("Total tests found: (\\d+)");
            Pattern succeededTestsPattern = Pattern.compile("Total tests succeeded: (\\d+)");
            Pattern failedTestPattern = Pattern.compile("Total tests failed: (\\d+)");
            Pattern executionTimePattern = Pattern.compile("Test run finished after: (\\d+) ms");

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = totalTestsPattern.matcher(line);
                if (matcher.find()) {
                    totalTests = Integer.parseInt(matcher.group(1));
                }

                matcher = succeededTestsPattern.matcher(line);
                if (matcher.find()) {
                    succeededTests = Integer.parseInt(matcher.group(1));
                }

                matcher = failedTestPattern.matcher(line);
                if (matcher.find()) {
                    failedTests = Integer.parseInt((matcher.group(1)));
                }

                matcher = executionTimePattern.matcher(line);
                if (matcher.find()) {
                    executionTime = Long.parseLong((matcher.group(1)));
                }
            }

            return new TestResult(totalTests, succeededTests, failedTests, executionTime, new Date());
        }
    }
}

