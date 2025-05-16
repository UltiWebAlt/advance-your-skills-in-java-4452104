package com.example.ch1;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

// Write your answer here, and then test your code.
// Your job is to implement the findAnswer() method.

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = true;

    // Return the highest grade for the students with a specific major
    static int findAnswer(List<Student> students, String major) {
        // Your code goes here.
        List<Student> result = students.stream()
                .filter(s -> s.getMajor() == major)
                .sorted(s -> s.grades.get("major"));
        return 0;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Amine", "Ousmane", "Computer Science", Map.of("Algorithms", 90, "Data Structures", 80, "Calculus", 85)),
                new Student("Lily-Ann", "Smith", "Mathematics", Map.of("Algorithms", 80, "Data Structures", 75, "Calculus", 88)),
                new Student("Li", "Wei", "Computer Science", Map.of("Algorithms", 92, "Data Structures", 89, "Calculus", 88)),
                new Student("Jessica", "Rodriguez", "Mathematics", Map.of("Algorithms", 85, "Data Structures", 80, "Calculus", 89)));
        String major = "Computer Science";
        int result = findAnswer(students, major);
    }
}


class Student {
    private String firstname;
    private String lastname;
    private String major;
    private Map<String, Integer> grades;

    public Student(String firstname, String lastname, String major, Map<String, Integer> grades) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
        this.grades = grades;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMajor() {
        return major;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}
