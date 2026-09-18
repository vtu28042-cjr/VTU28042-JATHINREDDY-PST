 1. Parking System

Problem Statement:
Design a parking system with big, medium, and small parking spaces. The addCar() method returns true if a space of the required type is available; otherwise, it returns false.

Java Code:

class ParkingSystem {
    int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && big > 0) {
            big--;
            return true;
        }

        if (carType == 2 && medium > 0) {
            medium--;
            return true;
        }

        if (carType == 3 && small > 0) {
            small--;
            return true;
        }

        return false;
    }
}

Sample Output:

true
true
false
false
2. Instanceof Keyword

Problem Statement:
Given objects of Student, Rockstar, and Hacker, use the instanceof operator to count the number of objects belonging to each class.

Java Code:

import java.util.*;

class Student {
}

class Rockstar {
}

class Hacker {
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();

            if (s.equals("Student"))
                list.add(new Student());
            else if (s.equals("Rockstar"))
                list.add(new Rockstar());
            else
                list.add(new Hacker());
        }

        int student = 0;
        int rockstar = 0;
        int hacker = 0;

        for (Object obj : list) {
            if (obj instanceof Student)
                student++;

            if (obj instanceof Rockstar)
                rockstar++;

            if (obj instanceof Hacker)
                hacker++;
        }

        System.out.println(student + " " + rockstar + " " + hacker);
    }
}

Sample Input:

6
Student
Rockstar
Hacker
Student
Rockstar
Hacker

Sample Output:

2 2 2
3. Underground Railway System

Problem Statement:
Design a railway system that records passenger check-in and check-out times and calculates the average travel time between two stations.

Java Code:

import java.util.*;

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Route {
        int total;
        int count;

        Route(int total, int count) {
            this.total = total;
            this.count = count;
        }
    }

    HashMap<Integer, CheckIn> checkins = new HashMap<>();
    HashMap<String, Route> routes = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkins.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn c = checkins.get(id);

        int time = t - c.time;

        String route = c.station + "#" + stationName;

        if (!routes.containsKey(route)) {
            routes.put(route, new Route(time, 1));
        } else {
            Route r = routes.get(route);
            r.total += time;
            r.count++;
        }

        checkins.remove(id);
    }

    public double getAverageTime(String startStation,
                                 String endStation) {

        Route r = routes.get(startStation + "#" + endStation);

        return (double) r.total / r.count;
    }
}

Sample Output:

14.0
11.0
4. Browser History

Problem Statement:
Design a browser history system that supports visiting new URLs, moving backward, and moving forward through the browsing history.

Java Code:

import java.util.*;

class BrowserHistory {

    ArrayList<String> history;
    int current;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();

        history.add(homepage);

        current = 0;
    }

    public void visit(String url) {

        while (history.size() > current + 1) {
            history.remove(history.size() - 1);
        }

        history.add(url);

        current++;
    }

    public String back(int steps) {

        current = Math.max(0, current - steps);

        return history.get(current);
    }

    public String forward(int steps) {

        current = Math.min(
            history.size() - 1,
            current + steps
        );

        return history.get(current);
    }
}

Sample Operations:

visit(google.com)
visit(facebook.com)
visit(youtube.com)
back(1)
back(1)
forward(1)

Sample Output:

facebook.com
google.com
facebook.com
5. MyHashSet

Problem Statement:
Design a custom HashSet without using Java's built-in HashSet. It should support add(), remove(), and contains() operations.

Java Code:

class MyHashSet {

    boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}

Sample Operations:

add(1)
add(2)
contains(1)
contains(3)
add(2)
contains(2)
remove(2)
contains(2)

Sample Output:

true
false
true
false
6. Grading Students

Problem Statement:
Given a list of student grades, round each grade according to the following rules:

Grades below 38 are not rounded.
Find the next multiple of 5.
If the difference between the grade and the next multiple is less than 3, round up.
Otherwise, keep the original grade.

Java Code:

import java.util.*;

public class Result {

    public static List<Integer> gradingStudents(
            List<Integer> grades) {

        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {

            if (grade < 38) {
                result.add(grade);
            } else {

                int next = ((grade / 5) + 1) * 5;

                if (next - grade < 3) {
                    result.add(next);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }
}

Sample Input:

4
73
67
38
33

Sample Output:

75
67
40
33
7. Animal and Bird Inheritance

Problem Statement:
Demonstrate inheritance in Java. The Bird class should inherit the walk() method from the Animal class and also have its own fly() and sing() methods.

Java Code:

class Animal {

    void walk() {
        System.out.println("I am walking");
    }
}

class Bird extends Animal {

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

Sample Output:

I am walking
I am flying
I am singing
8. Arithmetic and Adder Inheritance

Problem Statement:
Create an Arithmetic class with an add() method. Create an Adder class that inherits from Arithmetic. Use the Adder object to perform addition and display its superclass name.

Java Code:

class Arithmetic {

    public int add(int a, int b) {
        return a + b;
    }
}

class Adder extends Arithmetic {
}

public class Solution {

    public static void main(String[] args) {

        Adder a = new Adder();

        System.out.println(
            "My superclass is: " +
            a.getClass().getSuperclass().getName()
        );

        System.out.println(
            a.add(10, 32) + " " +
            a.add(10, 3) + " " +
            a.add(10, 10)
        );
    }
}

Sample Output:

My superclass is: Arithmetic
42 13 20
9. Generic Method – Print Array

Problem Statement:
Create a generic method called printArray() that can print elements of arrays of different data types. Demonstrate it using an Integer array and a String array.

Java Code:

import java.util.*;

class Printer {

    public <T> void printArray(T[] array) {

        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class Solution {

    public static void main(String args[]) {

        Printer printer = new Printer();

        Integer[] intArray = {1, 2, 3};

        String[] stringArray = {
            "Hello",
            "World"
        };

        printer.printArray(intArray);

        printer.printArray(stringArray);
    }
}

Sample Output:

1
2
3
Hello
World
10. Throne Inheritance

Problem Statement:
Design a system to maintain the inheritance order of a royal family. The system should support adding a child, marking a person as dead, and obtaining the current inheritance order. The inheritance order is generated using a depth-first traversal of the family tree.

Java Code:

import java.util.*;

class ThroneInheritance {

    String king;

    HashMap<String, List<String>> children;

    HashSet<String> dead;

    public ThroneInheritance(String kingName) {

        king = kingName;

        children = new HashMap<>();

        dead = new HashSet<>();
    }

    public void birth(String parentName,
                      String childName) {

        children.putIfAbsent(
            parentName,
            new ArrayList<>()
        );

        children.get(parentName).add(childName);
    }

    public void death(String name) {

        dead.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> result = new ArrayList<>();

        dfs(king, result);

        return result;
    }

    private void dfs(String name,
                     List<String> result) {

        if (!dead.contains(name)) {
            result.add(name);
        }

        if (children.containsKey(name)) {

            for (String child : children.get(name)) {

                dfs(child, result);
            }
        }
    }
}

Sample Operations:

birth(King, Andy)
birth(King, Bob)
birth(Andy, Matthew)
birth(Bob, Alex)
birth(Bob, Asha)
death(Andy)

Sample Output:

King
Matthew
Bob
Alex
Asha
