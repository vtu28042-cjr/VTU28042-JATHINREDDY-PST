1.Find Pivot Index.java
class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;

     
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
2.Java Comparator.java
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {

       
        if (a.score != b.score) {
            return Integer.compare(b.score, a.score);
        }

     
        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player p : players) {
            System.out.println(p.name + " " + p.score);
        }

        sc.close();
    }
}
3.Java Lambda Expressions.java
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a < 2) {
                return false;
            }

            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String s = String.valueOf(a);
            String reverse = new StringBuilder(s).reverse().toString();

            return s.equals(reverse);
        };
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int condition = sc.nextInt();
            int number = sc.nextInt();

            if (condition == 1) {
                System.out.println(
                    MyMath.checker(MyMath.isOdd(), number)
                    ? "ODD"
                    : "EVEN"
                );

            } else if (condition == 2) {
                System.out.println(
                    MyMath.checker(MyMath.isPrime(), number)
                    ? "PRIME"
                    : "COMPOSITE"
                );

            } else if (condition == 3) {
                System.out.println(
                    MyMath.checker(MyMath.isPalindrome(), number)
                    ? "PALINDROME"
                    : "NOT PALINDROME"
                );
            }
        }

        sc.close();
    }
}
4.Java Sort.java
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {

                 
                if (s1.getCgpa() < s2.getCgpa()) {
                    return 1;
                } else if (s1.getCgpa() > s2.getCgpa()) {
                    return -1;
                }
 
                int nameCompare = s1.getName().compareTo(s2.getName());

                if (nameCompare != 0) {
                    return nameCompare;
                }

            
                return Integer.compare(s1.getId(), s2.getId());
            }
        });

        for (Student student : students) {
            System.out.println(student.getName());
        }

        sc.close();
    }
}
5.Richest Customer Wealth.java
class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for (int i = 0; i < accounts.length; i++) {

            int currentWealth = 0;

            for (int j = 0; j < accounts[i].length; j++) {
                currentWealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }
}
6.Running Sum of 1D Array.java
class Solution {
    public int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}
7.Sort Array By Parity.java
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            while (left < right && nums[left] % 2 == 0) {
                left++;
            }

            while (left < right && nums[right] % 2 != 0) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return nums;
    }
}
8.Sorting: Comparator.java
import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return Integer.compare(b.score, a.score);
        }

        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();

            players[i] = new Player(name, score);
        }

        Arrays.sort(players, new Checker());

        for (Player player : players) {
            System.out.println(player.name + " " + player.score);
        }

        scanner.close();
    }
}
9.Squares of a Sorted Array.java
class Solution {
    public int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }

        return result;
    }
}
