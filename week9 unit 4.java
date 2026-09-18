TASK 1 – LAB TASK 5
Bank Account Management System
Problem Statement

Design a Java program to implement a simple Bank Account Management System using encapsulation. The program should allow the user to create a bank account with an account number, account holder name, and initial balance. It should provide options to deposit money, withdraw money, check the balance, display account details, and exit. The withdrawal should be allowed only when sufficient balance is available.

Java Code
import java.util.*;

class BankAccount {

    private int accountNumber;
    private String name;
    private double balance;

    public BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited successfully");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account =
            new BankAccount(accountNumber, name, balance);

        int choice;

        do {

            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    double deposit = sc.nextDouble();

                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdraw = sc.nextDouble();

                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayAccount();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
Sample Input
Enter account number: 101
Enter name: Jathin
Enter initial balance: 5000

1. Deposit
2. Withdraw
3. Check Balance
4. Display Account
5. Exit
Enter your choice: 1
Enter amount: 2000

Enter your choice: 2
Enter amount: 1000

Enter your choice: 3

Enter your choice: 4

Enter your choice: 5
Sample Output
Amount deposited successfully
Amount withdrawn successfully
Current Balance: 6000.0

Account Number: 101
Name: Jathin
Balance: 6000.0

Thank you!
TASK 2 – LAB TASK 6
Ride Fare Calculation
Problem Statement

Design a Java program to calculate the fare for different types of rides using abstraction and inheritance. Create an abstract class Ride containing the distance and an abstract method calculateFare(). Implement the method differently for Bike, Auto, and Cab.

The fare rates are:

Bike: ₹10 per km
Auto: ₹15 per km
Cab: ₹20 per km
Java Code
import java.util.*;

abstract class Ride {

    double distance;

    Ride(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bike extends Ride {

    Bike(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 10;
    }
}

class Auto extends Ride {

    Auto(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 15;
    }
}

class Cab extends Ride {

    Cab(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 20;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance: ");
        double distance = sc.nextDouble();

        Ride bike = new Bike(distance);
        Ride auto = new Auto(distance);
        Ride cab = new Cab(distance);

        System.out.println(
            "Bike Fare: " + bike.calculateFare()
        );

        System.out.println(
            "Auto Fare: " + auto.calculateFare()
        );

        System.out.println(
            "Cab Fare: " + cab.calculateFare()
        );

        sc.close();
    }
}
Sample Input
Enter distance: 10
Sample Output
Bike Fare: 100.0
Auto Fare: 150.0
Cab Fare: 200.0
TASK 3
Vehicle Rental System
Problem Statement

Design a Java program for a Vehicle Rental System using inheritance and method overriding. The system should support three types of vehicles: Car, Bike, and Truck.

The rental amount is calculated based on the number of days:

Car: Normal rent
Bike: 10% discount on the total rent
Truck: 20% additional charge on the total rent

The program should display the vehicle number and total rental amount.

Java Code
import java.util.*;

class Vehicle {

    String vehicleNumber;
    double rentPerDay;

    Vehicle(String vehicleNumber, double rentPerDay) {
        this.vehicleNumber = vehicleNumber;
        this.rentPerDay = rentPerDay;
    }

    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days;
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 0.90;
    }
}

class Truck extends Vehicle {

    Truck(String vehicleNumber, double rentPerDay) {
        super(vehicleNumber, rentPerDay);
    }

    @Override
    double calculateRent(int days) {
        return rentPerDay * days * 1.20;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int type = sc.nextInt();
            String vehicleNumber = sc.next();
            double rentPerDay = sc.nextDouble();
            int days = sc.nextInt();

            Vehicle vehicle;

            if (type == 1) {
                vehicle =
                    new Car(vehicleNumber, rentPerDay);
            }
            else if (type == 2) {
                vehicle =
                    new Bike(vehicleNumber, rentPerDay);
            }
            else {
                vehicle =
                    new Truck(vehicleNumber, rentPerDay);
            }

            double totalRent =
                vehicle.calculateRent(days);

            System.out.printf(
                "%s %.2f%n",
                vehicleNumber,
                totalRent
            );
        }

        sc.close();
    }
}
Sample Input
3
1 CAR101 1000 3
2 BIKE202 500 4
3 TRUCK303 2000 2
Sample Output
CAR101 3000.00
BIKE202 1800.00
TRUCK303 4800.00
TASK 4
Online Payment Processing System
Problem Statement

Design a Java program for an Online Payment Processing System using interfaces, abstraction, inheritance, and the instanceof operator.

The system supports:

Credit Card – 2% processing fee
UPI – 1% processing fee
Net Banking – 1.5% processing fee

Calculate and display the final payment amount after adding the applicable processing fee.

Java Code
import java.util.*;

interface Payment {

    void pay(double amount);
}

class CreditCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println(
            "CreditCard payment: " + amount
        );
    }
}

class UPIPayment implements Payment {

    public void pay(double amount) {
        System.out.println(
            "UPI payment: " + amount
        );
    }
}

class NetBankingPayment implements Payment {

    public void pay(double amount) {
        System.out.println(
            "NetBanking payment: " + amount
        );
    }
}

abstract class PaymentProcessor {

    abstract double processPayment(
        Payment payment,
        double amount
    );
}

class OnlinePaymentProcessor
        extends PaymentProcessor {

    public double processPayment(
            Payment payment,
            double amount) {

        double fee;

        if (payment instanceof CreditCardPayment) {

            fee = amount * 0.02;
        }
        else if (payment instanceof UPIPayment) {

            fee = amount * 0.01;
        }
        else if (payment instanceof NetBankingPayment) {

            fee = amount * 0.015;
        }
        else {

            fee = 0;
        }

        return amount + fee;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentProcessor processor =
            new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {

            int paymentType = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;

            if (paymentType == 1) {

                payment =
                    new CreditCardPayment();
            }
            else if (paymentType == 2) {

                payment =
                    new UPIPayment();
            }
            else {

                payment =
                    new NetBankingPayment();
            }

            double finalAmount =
                processor.processPayment(
                    payment,
                    amount
                );

            if (paymentType == 1) {

                System.out.printf(
                    "CreditCard %.2f%n",
                    finalAmount
                );
            }
            else if (paymentType == 2) {

                System.out.printf(
                    "UPI %.2f%n",
                    finalAmount
                );
            }
            else {

                System.out.printf(
                    "NetBanking %.2f%n",
                    finalAmount
                );
            }
        }

        sc.close();
    }
}
Sample Input
3
1 1000
2 2000
3 3000
Sample Output
CreditCard 1020.00
UPI 2020.00
NetBanking 3045.00
TASK 5
Division with Exception Handling
Problem Statement

Write a Java program to read two integers and perform integer division. Handle exceptions using try-catch.

The program should handle:

ArithmeticException when the divisor is zero.
InputMismatchException when the input is not an integer.
Java Code
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(x / y);
        }
        catch (ArithmeticException e) {

            System.out.println(
                "java.lang.ArithmeticException: / by zero"
            );
        }
        catch (InputMismatchException e) {

            System.out.println(
                "java.util.InputMismatchException"
            );
        }

        sc.close();
    }
}
Sample Input 1
10 2
Sample Output 1
5
Sample Input 2 – Division by Zero
10 0
Sample Output 2
java.lang.ArithmeticException: / by zero
Sample Input 3 – Invalid Input
10 abc
Sample Output 3
java.util.InputMismatchException
