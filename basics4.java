package javaarchive;

import java.util.ArrayList;
import java.util.HashMap;

public class basics4 {
    public static void main(String[] args) {
        // ArrayList example
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits ArrayList:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // HashMap example
        HashMap<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 95);
        studentGrades.put("Bob", 87);
        studentGrades.put("Charlie", 92);

        System.out.println("\nStudent Grades HashMap:");
        for (String student : studentGrades.keySet()) {
            System.out.println(student + ": " + studentGrades.get(student));
        }

        // Method calls
        int sum = addNumbers(5, 10);
        System.out.println("\nSum of 5 and 10: " + sum);

        String greeting = greet("World");
        System.out.println(greeting);

        // Exception handling
        try {
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method examples
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    public static String greet(String name) {
        return "Hello, " + name + "!";
    }

    public static int divideNumbers(int a, int b) {
        return a / b;
    }
}
