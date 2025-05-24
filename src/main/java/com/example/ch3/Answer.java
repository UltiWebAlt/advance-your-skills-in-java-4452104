package com.example.ch3;
// Java code​​​​​​‌‌​‌​‌‌​​​​​​​‌​‌‌​​‌​​​‌ below

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Write your answer here, and then test your code.
// Your job is to implement the annotation and add it to the findAnswer() method.

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    // Add annotation to this method
    @MethodDescription(value = "Find the answer")
    public static void findAnswer() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        // Call the findAnswer() method
        findAnswer();

        // Print the annotation information
        MethodDescription annotation = Answer.class.getMethod("findAnswer").getAnnotation(MethodDescription.class);
        System.out.println("Value: " + annotation.value());
    }

}

// The implementation of the annotation goes here
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MethodDescription {
    // The value
    String value();
}
