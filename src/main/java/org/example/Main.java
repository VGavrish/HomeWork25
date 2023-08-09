package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.TestRunner.*;

public class Main {
    public static void main(String[] args) {

//        runTestsByClassName("org.example.SimpleMathLibraryTest");
//
//        runTestByClass(SimpleMathLibraryTest.class);

//        List<String> classesString = new ArrayList<>();
//        classesString.add("org.example.SimpleMathLibraryTest");
//        runTestsByByClassNames(classes);

//        List<Class> classesClass = new ArrayList<>();
//        classesClass.add(SimpleMathLibraryTest.class);
//        runTestByClasses(classesClass);

//        runTestByPackage("org.example");

//        File testResultFile = new File("C:\\Users\\Kater\\IdeaProjects\\HomeWork25\\Test_results.txt");
//
//        try {
//            TestResult testResult = TestResultParser.parse(testResultFile);
//            System.out.println(testResult);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        runTestsByClassName("org.example.ArrayUtilsTest");


    }
}
