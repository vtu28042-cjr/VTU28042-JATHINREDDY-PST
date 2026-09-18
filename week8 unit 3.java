1. Animal and Bird – Inheritance
Problem Statement

Create an Animal class with a walk() method. Create a Bird class that extends Animal and contains walk(), fly(), and sing() methods. Create a Bird object and call all three methods to demonstrate inheritance and method overriding.

Java Code
class Animal {

    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {

    void walk() {
        System.out.println("I am walking");
    }

    void fly() {
        System.out.println("I am flying");
    }

    void sing() {
        System.out.println("I am singing");
    }
}

public class Solution {

    public static void main(String[] args) {

        Bird bird = new Bird();

        bird.walk();
        bird.fly();
        bird.sing();
    }
}
Sample Input
No input
Sample Output
I am walking
I am flying
I am singing
2. Arithmetic and Adder – super Keyword
Problem Statement

Create an Arithmetic class containing a string variable and a method. Create an Adder class that extends Arithmetic and overrides the method. Use the super keyword to access the superclass variable and method.

Java Code
class Arithmetic {

    String myString = "Hello";

    public void myMethod() {
        System.out.println("Hello from Arithmetic");
    }
}

class Adder extends Arithmetic {

    String myString = "Hello from Adder";

    public void myMethod() {

        System.out.println("Hello from Adder");

        System.out.println(super.myString);

        super.myMethod();
    }
}

public class Solution {

    public static void main(String[] args) {

        Adder a = new Adder();

        a.myMethod();
    }
}
Sample Input
No input
Sample Output
Hello from Adder
Hello
Hello from Arithmetic
3. Singleton Pattern
Problem Statement

Implement the Singleton Design Pattern in Java. A Singleton class should allow only one object of the class to be created. The constructor must be private, and a static method should return the single instance of the class.

Java Code
class Singleton {

    private static Singleton instance;

    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
Sample Input
No input
Sample Output
No direct output

Concept:
The getSingleInstance() method creates the object only when instance is null. Every subsequent call returns the same object.

4. Tree Visitor Pattern
Problem Statement

Design a tree structure using an abstract Tree class and two subclasses: TreeNode and TreeLeaf. Use the Visitor Design Pattern through the TreeVis interface to perform operations on tree nodes and leaves. Each tree contains a value and depth, and nodes can have multiple children.

Java Code
import java.util.*;

abstract class Tree {

    private int value;
    private int depth;

    public Tree(int value, int depth) {

        this.value = value;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

interface TreeVis {

    int getResult();

    void visitNode(TreeNode node);

    void visitLeaf(TreeLeaf leaf);
}

class TreeNode extends Tree {

    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, int depth) {
        super(value, depth);
    }

    public void accept(TreeVis visitor) {

        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, int depth) {
        super(value, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}
Sample Input
No input for the given code
Sample Output
No direct output

Note: This code defines the tree and visitor structure, but it does not contain a main() method or create a visitor, so nothing is printed when this code is compiled and executed by itself.

5. Iterator
Problem Statement

Write a Java program that reads a collection of objects and uses an Iterator to traverse the collection. The program should print every element in the same order in which it was entered.

Java Code
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            list.add(sc.next());
        }

        Iterator<Object> iterator = list.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}
Sample Input
5
Apple
Banana
Mango
Orange
Grapes
Sample Output
Apple
Banana
Mango
Orange
Grapes 
6. Advanced Arithmetic – Interface
Problem Statement

Create an interface named AdvancedArithmetic with a method divisor_sum(int n). Implement this interface using the MyCalculator class. The divisor_sum() method should calculate the sum of all positive divisors of a given number. Also display the name of the implemented interface.

Java Code
interface AdvancedArithmetic {

    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}

public class Solution {

    public static void main(String[] args) {

        MyCalculator myCalculator = new MyCalculator();

        System.out.println(
            "I implemented: " +
            myCalculator.getClass()
                        .getInterfaces()[0]
                        .getName()
        );
    }
}
Sample Input
No input
Sample Output
I implemented: AdvancedArithmetic
7. HashSet – Unique Pairs
Problem Statement

Given several pairs of strings, store each pair in a HashSet. Since a HashSet does not allow duplicate elements, print the number of unique pairs after reading each pair.

Java Code
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {

            String a = sc.next();
            String b = sc.next();

            set.add(a + " " + b);

            System.out.println(set.size());
        }
    }
}
Sample Input
5
john tom
john mary
john tom
mary tom
john mary
Sample Output
1
2
2
3
3
8. Factory Pattern – Food Factory
Problem Statement

Create a Food interface with a getType() method. Implement the interface using Pizza and Cake classes. Create a FoodFactory class that returns the appropriate food object based on the user's order. Demonstrate the Factory Design Pattern.

Java Code
import java.util.*;

interface Food {

    public String getType();
}

class Pizza implements Food {

    public String getType() {

        return "The factory returned class Pizza";
    }
}

class Cake implements Food {

    public String getType() {

        return "The factory returned class Cake";
    }
}

class FoodFactory {

    public Food getFood(String order) {

        if (order.equals("pizza")) {
            return new Pizza();
        }

        if (order.equals("cake")) {
            return new Cake();
        }

        return null;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodFactory factory = new FoodFactory();

        Food food = factory.getFood(sc.nextLine());

        System.out.println(
            "The factory returned " +
            food.getClass().getSimpleName()
        );

        System.out.println(food.getType());
    }
}
Sample Input
pizza
Sample Output
The factory returned Pizza
The factory returned class Pizza
Another Sample Input
cake
Another Sample Output
The factory returned Cake
The factory returned class Cake
9. Factorial – Exception Handling
Problem Statement

Write a Java program to calculate the factorial of a given non-negative integer. If the user enters a negative number, throw an exception and display an appropriate error message. Use try-catch for exception handling.

Java Code
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int n = sc.nextInt();

            if (n < 0) {

                throw new Exception(
                    "Exception: n should be greater than 0"
                );
            }

            long factorial = 1;

            for (int i = 1; i <= n; i++) {

                factorial *= i;
            }

            System.out.println(factorial);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}
Sample Input
5
Sample Output
120
Sample Input – Negative Number
-3
Sample Output
Exception: n should be greater than 0

10. Division – Exception Handling
Problem Statement

Write a Java program that reads two integers and performs integer division. Handle two possible exceptions:

ArithmeticException when the second number is zero.
InputMismatchException when the input is not an integer.

Display the corresponding exception message.

Java Code
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.println(x / y);

        } catch (ArithmeticException e) {

            System.out.println(e);

        } catch (InputMismatchException e) {

            System.out.println(e);
        }
    }
}
Sample Input
10 2
Sample Output
5
Sample Input – Division by Zero
10 0
Sample Output
java.lang.ArithmeticException: / by zero
Sample Input – Invalid Input
10 a
Sample Output
java.util.InputMismatchException
