package javaarchive;

public class basics3 {
    public static void main(String[] args) {
        // Basic data types
        int age = 25;
        double height = 5.9;
        boolean isStudent = true;
        char grade = 'A';
        String name = "John Doe";

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Is Student: " + isStudent);
        System.out.println("Grade: " + grade);

        // Basic conditional
        if (age >= 18) {
            System.out.println(name + " is an adult.");
        } else {
            System.out.println(name + " is a minor.");
        }

        // Basic loop
        System.out.println("Counting to 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Array example
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("First element: " + numbers[0]);
        System.out.println("Array length: " + numbers.length);
    }
}
