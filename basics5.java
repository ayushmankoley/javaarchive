package javaarchive;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class basics5 {
    public static void main(String[] args) {
        // String operations
        String text = "Hello, Java Programming!";
        System.out.println("Original text: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Replace 'Java' with 'Python': " + text.replace("Java", "Python"));

        // Array operations
        int[] numbers = {5, 2, 8, 1, 9, 3};
        System.out.println("\nOriginal array: " + Arrays.toString(numbers));

        // Sort array
        Arrays.sort(numbers);
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        // Find max and min
        int max = Arrays.stream(numbers).max().getAsInt();
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Max: " + max + ", Min: " + min);

        // Stream operations
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("\nOriginal list: " + numberList);

        // Filter even numbers
        List<Integer> evenNumbers = numberList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Map to squares
        List<Integer> squares = numberList.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        // Sum all numbers
        int sum = numberList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);

        // Object-oriented basics
        Person person = new Person("Alice", 25);
        person.displayInfo();

        Student student = new Student("Bob", 20, "Computer Science");
        student.displayInfo();
    }
}

// Simple class example
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("\nPerson - Name: " + name + ", Age: " + age);
    }
}

// Inheritance example
class Student extends Person {
    String major;

    Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    void displayInfo() {
        System.out.println("\nStudent - Name: " + name + ", Age: " + age + ", Major: " + major);
    }
}
