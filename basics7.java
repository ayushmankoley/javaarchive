package javaarchive;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

// Custom exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Enum example
enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// Singleton pattern
class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private final String connectionString;

    private DatabaseConnection() {
        this.connectionString = "Connected to database at " + LocalDateTime.now();
        System.out.println("Database connection established: " + connectionString);
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public String getConnectionString() {
        return connectionString;
    }
}

// Factory pattern
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Email: " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📱 SMS: " + message);
    }
}

class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("🔔 Push: " + message);
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SMSNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}

// Banking system with concurrency
class BankAccount {
    private final String accountNumber;
    private double balance;
    private final Object lock = new Object();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        synchronized (lock) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to " + accountNumber + ". New balance: $" + balance);
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        synchronized (lock) {
            if (balance < amount) {
                throw new InsufficientFundsException("Insufficient funds in account " + accountNumber);
            }
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountNumber + ". New balance: $" + balance);
        }
    }

    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class basics7 {
    public static void main(String[] args) {
        System.out.println("=== Super Advanced Java Concepts ===\n");

        // Modern Date/Time API
        System.out.println("1. Modern Date/Time API:");
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedNow = ZonedDateTime.now();
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        System.out.println("Current DateTime: " + now);
        System.out.println("Zoned DateTime: " + zonedNow);
        System.out.println("Today: " + today);
        System.out.println("Current Time: " + currentTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted: " + now.format(formatter));

        // Optional class
        System.out.println("\n2. Optional Class:");
        Optional<String> optionalName = Optional.ofNullable(getUserName());
        System.out.println("Name: " + optionalName.orElse("Anonymous"));
        optionalName.ifPresent(name -> System.out.println("Welcome, " + name + "!"));

        // Enum usage
        System.out.println("\n3. Enum Example:");
        Priority taskPriority = Priority.HIGH;
        System.out.println("Task priority: " + taskPriority + " (value: " + taskPriority.getValue() + ")");

        // Singleton pattern
        System.out.println("\n4. Singleton Pattern:");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("Same instance: " + (db1 == db2));
        System.out.println("Connection: " + db1.getConnectionString());

        // Factory pattern
        System.out.println("\n5. Factory Pattern:");
        Notification email = NotificationFactory.createNotification("email");
        Notification sms = NotificationFactory.createNotification("sms");
        Notification push = NotificationFactory.createNotification("push");

        email.send("Welcome to our platform!");
        sms.send("Your verification code is 123456");
        push.send("You have a new message");

        // Multithreading with concurrent banking
        System.out.println("\n6. Multithreading & Concurrency:");
        BankAccount account = new BankAccount("ACC-001", 1000.0);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit multiple concurrent transactions
        IntStream.range(0, 5).forEach(_ -> {
            executor.submit(() -> {
                try {
                    account.deposit(100.0);
                    Thread.sleep(50); // Simulate processing time
                    account.withdraw(50.0);
                } catch (InterruptedException | InsufficientFundsException e) {
                    System.out.println("Transaction error: " + e.getMessage());
                }
            });
        });

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Executor interrupted");
        }

        System.out.println("Final balance: $" + account.getBalance());

        // Custom exception handling
        System.out.println("\n7. Custom Exception Handling:");
        try {
            account.withdraw(2000.0); // This should fail
        } catch (InsufficientFundsException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }

        System.out.println("\n=== All Super Advanced Concepts Demonstrated! ===");
    }

    // Method that may return null (for Optional demo)
    private static String getUserName() {
        // Simulate sometimes returning null
        return Math.random() > 0.5 ? "John Doe" : null;
    }
}
