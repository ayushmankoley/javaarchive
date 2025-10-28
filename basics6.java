package javaarchive;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class basics6 {
    public static void main(String[] args) {
        System.out.println("=== Advanced Java Concepts ===\n");

        // Generics example
        System.out.println("1. Generics:");
        GenericBox<String> stringBox = new GenericBox<>("Hello Generics!");
        System.out.println("String Box: " + stringBox.getItem());

        GenericBox<Integer> intBox = new GenericBox<>(42);
        System.out.println("Integer Box: " + intBox.getItem());

        // Lambda expressions and functional interfaces
        System.out.println("\n2. Lambda Expressions:");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana");

        // Using lambda with Predicate
        Predicate<String> startsWithA = name -> name.startsWith("A");
        System.out.println("Names starting with 'A': " +
            names.stream().filter(startsWithA).collect(java.util.stream.Collectors.toList()));

        // Using lambda with Consumer
        Consumer<String> printName = name -> System.out.println("Hello, " + name + "!");
        System.out.println("Greeting each person:");
        names.forEach(printName);

        // Using lambda with Function
        Function<String, Integer> nameLength = String::length;
        System.out.println("Name lengths: " +
            names.stream().map(nameLength).collect(java.util.stream.Collectors.toList()));

        // Interface and abstract class example
        System.out.println("\n3. Interfaces and Abstract Classes:");
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Circle perimeter: " + circle.calculatePerimeter());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        System.out.println("Rectangle perimeter: " + rectangle.calculatePerimeter());

        // File I/O example
        System.out.println("\n4. File I/O:");
        try {
            // Write to file
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello, this is a sample file!\n");
            writer.write("Created by basics6.java\n");
            writer.close();
            System.out.println("File written successfully");

            // Read from file
            FileReader reader = new FileReader("sample.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            System.out.println("Reading from file:");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

            // Clean up
            new File("sample.txt").delete();
            System.out.println("File cleaned up");

        } catch (IOException e) {
            System.out.println("File I/O error: " + e.getMessage());
        }

        // Advanced collections - TreeMap and TreeSet
        System.out.println("\n5. Advanced Collections:");
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Charlie", 85);
        sortedMap.put("Alice", 95);
        sortedMap.put("Bob", 90);
        System.out.println("TreeMap (sorted by key): " + sortedMap);

        TreeSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(5);
        sortedSet.add(1);
        sortedSet.add(3);
        sortedSet.add(2);
        System.out.println("TreeSet (sorted): " + sortedSet);
    }
}

// Generic class
class GenericBox<T> {
    private T item;

    public GenericBox(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

// Interface
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Abstract class
abstract class AbstractShape implements Shape {
    protected String name;

    public AbstractShape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete implementations
class Circle extends AbstractShape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}
