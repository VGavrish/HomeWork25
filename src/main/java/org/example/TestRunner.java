package org.example;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestRunner {
    private static long startTimeMillis;
    public static void runTestsByClassName(String className) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectClass(className))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        printSummary(summary);
    }

    public static void runTestByClass(Class<?> testClass) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectClass(testClass))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        TestExecutionSummary summary = listener.getSummary();
        printSummary(summary);
    }

    public static void runTestsByByClassNames(List<String> className) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(className.stream().map(DiscoverySelectors::selectClass).collect(Collectors.toList()))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        printSummary(summary);
    }

    public static void runTestByClasses(List<Class> classesNames) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(classesNames.stream().map(DiscoverySelectors::selectClass).collect(Collectors.toList()))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();
        printSummary(summary);
    }

    public static void runTestByPackage(String packageName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(selectPackage(packageName))
                .build();

        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        TestExecutionSummary summary = listener.getSummary();

        printSummary(summary);
    }

    private static void printSummary(TestExecutionSummary summary) {
        String fileName = "Test_results.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            long endTimeMillis = System.currentTimeMillis();
            long elapsedTimeMillis = endTimeMillis - startTimeMillis;
            writer.println("Detailed test results:");
            writer.println("Total tests found: " + summary.getTestsFoundCount());
            writer.println("Total tests succeeded: " + summary.getTestsSucceededCount());
            writer.println("Total tests failed: " + summary.getTestsFailedCount());
            writer.println("Test run finished after: " + elapsedTimeMillis + " ms");
            writer.println("--------------------------------------");

            System.out.println("Detailed test results:");
            System.out.println("Total tests found: " + summary.getTestsFoundCount());
            System.out.println("Total tests succeeded: " + summary.getTestsSucceededCount());
            System.out.println("Total tests failed: " + summary.getTestsFailedCount());
            System.out.println("Test run finished after: " + elapsedTimeMillis + " ms");
            System.out.println("--------------------------------------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
