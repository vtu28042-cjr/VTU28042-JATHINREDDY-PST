1.Compare the Triplets – HackerRank

Problem Statement

Alice and Bob each have a list of three ratings. Their ratings are compared one by one.

If Alice's rating is greater than Bob's, Alice gets 1 point.
If Bob's rating is greater than Alice's, Bob gets 1 point.
If both ratings are equal, neither gets a point.

The program must calculate and return the total score of Alice and Bob.

Input Format
The first line contains three integers representing Alice's ratings.
The second line contains three integers representing Bob's ratings.
Output Format

Print two integers:

Alice's score
Bob's score
Example

Input:

5 6 7
3 6 10

Output:

1 1
Java Code
import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                alice++;
            } else if (a.get(i) < b.get(i)) {
                bob++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(alice);
        result.add(bob);

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(
            bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ")
        ).map(Integer::parseInt).collect(toList());

        List<Integer> b = Stream.of(
            bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ")
        ).map(Integer::parseInt).collect(toList());

        List<Integer> result = Result.compareTriplets(a, b);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

2. Contains Duplicate

Problem Statement

Given an integer array nums, determine whether the array contains any duplicate values.

Return:

true if any value appears at least twice.
false if every value appears only once.
Example

Input:

nums = [1, 2, 3, 1]

Output:

true

Explanation:
The number 1 appears twice in the array.

Another Example

Input:

nums = [1, 2, 3, 4]

Output:

false

Explanation:
All elements are unique.

Java Code
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
3.Halves Are Alike

Problem Statement

Given a string s of even length, divide it into two equal halves.

The string contains uppercase and lowercase English letters. Count the number of vowels (a, e, i, o, u) in each half.

Return:

true if both halves contain the same number of vowels.
false otherwise.
Example 1

Input:

book

Output:

true

Explanation:
First half: bo → 1 vowel (o)
Second half: ok → 1 vowel (o)
Both halves have the same number of vowels.

Example 2

Input:

textbook

Output:

false

Explanation:
First half: text → 1 vowel
Second half: book → 2 vowels
Therefore, the halves are not alike.

Java Code
class Solution {
    public boolean halvesAreAlike(String s) {

        int count = 0;
        int n = s.length();

        // Count vowels in the first half
        for (int i = 0; i < n / 2; i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }

        // Count vowels in the second half
        for (int i = n / 2; i < n; i++) {
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count--;
            }
        }

        return count == 0;
    }
4.Diagonal Difference

Problem Statement

Given a square matrix of integers, calculate the absolute difference between the sums of its two diagonals.

Primary diagonal: Elements from the top-left to the bottom-right.
Secondary diagonal: Elements from the top-right to the bottom-left.

Return the absolute difference between these two diagonal sums.

Example

Input:

11 2 4
4 5 6
10 8 -12

Output:

15

Explanation:

Primary diagonal:
11 + 5 + (-12) = 4

Secondary diagonal:
4 + 5 + 10 = 19

Absolute difference:
|4 - 19| = 15

Java Code
import java.util.*;

public class Solution {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int n = arr.size();

        int diagonal1 = 0;
        int diagonal2 = 0;

        for (int i = 0; i < n; i++) {

            // Primary diagonal
            diagonal1 += arr.get(i).get(i);

            // Secondary diagonal
            diagonal2 += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(diagonal1 - diagonal2);
    }
}

}
5. Anagram – Check Whether Two Halves Are Anagrams

Problem Statement

Given a string s, divide it into two halves. Determine whether the two halves contain the same characters with the same frequencies, regardless of their order.

If the string length is even, divide it into two equal halves.
If the string length is odd, ignore the middle character.
Print YES if the two halves are anagrams.
Otherwise, print NO.
Example

Input:

2
abba
abcba

Output:

YES
YES

Explanation:

For abba:

First half: ab
Second half: ba
Both contain one a and one b → YES.

For abcba:

First half: ab
Middle character: c (ignored)
Second half: ba
Both halves are anagrams → YES.
Java Code
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();

            int n = s.length();
            int[] freq = new int[26];

            // First half
            for (int i = 0; i < n / 2; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // Second half
            for (int i = (n + 1) / 2; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean answer = true;

            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    answer = false;
                    break;
                }
            }

            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
6.Matrix Block Sum

Problem Statement

Given a matrix mat and an integer k, calculate the block sum for every cell.

For each cell (i, j), calculate the sum of all elements whose row and column indices are within k positions from (i, j).

The block boundaries must stay within the matrix.

Example

Input:

mat =
[
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]

k = 1

Output:

[
  [12, 21, 16],
  [27, 45, 33],
  [24, 39, 28]
]
Explanation

For the center element 5, with k = 1, the surrounding block is:

1 2 3
4 5 6
7 8 9

Sum = 45.

For the top-left element 1, the block is:

1 2
4 5

Sum = 12.

Java Code
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;

                for (int r = Math.max(0, i - k);
                     r <= Math.min(m - 1, i + k); r++) {

                    for (int c = Math.max(0, j - k);
                         c <= Math.min(n - 1, j + k); c++) {

                        sum += mat[r][c];
                    }
                }

                result[i][j] = sum;
            }
        }

        return result;
    }
}
7.Matrix Layer Rotation

Problem Statement

Given a matrix with m rows and n columns and an integer r, rotate the matrix counter-clockwise by r positions.

The matrix is divided into multiple layers (rings). Each layer is rotated independently.

For example:

1  2  3  4
5  6  7  8
9 10 11 12

The outer layer is:

1 → 2 → 3 → 4 → 8 → 12 → 11 → 10 → 9 → 5

After rotation, the elements move r positions counter-clockwise.

Input Format
The matrix dimensions are represented by m and n.
The matrix contains m × n integers.
r represents the number of rotations.
Output Format

Print the matrix after performing r counter-clockwise rotations.

Java Code
import java.util.*;

public class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> temp = new ArrayList<>();

            // Top
            for (int j = layer; j < n - layer; j++)
                temp.add(matrix.get(layer).get(j));

            // Right
            for (int i = layer + 1; i < m - layer; i++)
                temp.add(matrix.get(i).get(n - layer - 1));

            // Bottom
            for (int j = n - layer - 2; j >= layer; j--)
                temp.add(matrix.get(m - layer - 1).get(j));

            // Left
            for (int i = m - layer - 2; i > layer; i--)
                temp.add(matrix.get(i).get(layer));

            int size = temp.size();
            int shift = r % size;

            int index = shift;

            // Top
            for (int j = layer; j < n - layer; j++) {
                matrix.get(layer).set(j, temp.get(index));
                index = (index + 1) % size;
            }

            // Right
            for (int i = layer + 1; i < m - layer; i++) {
                matrix.get(i).set(n - layer - 1, temp.get(index));
                index = (index + 1) % size;
            }

            // Bottom
            for (int j = n - layer - 2; j >= layer; j--) {
                matrix.get(m - layer - 1).set(j, temp.get(index));
                index = (index + 1) % size;
            }

            // Left
            for (int i = m - layer - 2; i > layer; i--) {
                matrix.get(i).set(layer, temp.get(index));
                index = (index + 1) % size;
            }
        }

        // Print rotated matrix
        for (List<Integer> row : matrix) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
8.Time Conversion – 12-Hour to 24-Hour Format

Problem Statement

Given a time in 12-hour AM/PM format, convert it into 24-hour (military) time.

The input time is given in the format:

hh:mm:ssAM

or

hh:mm:ssPM
Conversion Rules
12:00:00AM → 00:00:00
Any hour from 01 to 11 with AM remains unchanged.
Any hour from 01 to 11 with PM has 12 added.
12:00:00PM remains 12:00:00.
Example 1

Input:

07:05:45PM

Output:

19:05:45
Example 2

Input:

12:01:00AM

Output:

00:01:00
Java Code
import java.io.*;

class Result {

    public static String timeConversion(String s) {

        String ampm = s.substring(8, 10);
        int hour = Integer.parseInt(s.substring(0, 2));

        if (ampm.equals("AM")) {

            if (hour == 12) {
                hour = 0;
            }

        } else {

            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d", hour) + s.substring(2, 8);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
            );

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
9.Matrix Transpose

Problem Statement

Given a matrix with rows rows and cols columns, find its transpose.

The transpose of a matrix is obtained by converting each row into a column and each column into a row.

For every element:

result[j][i] = matrix[i][j]
Example

Input:

1 2 3
4 5 6

Output:

1 4
2 5
3 6
Explanation

The original matrix has 2 rows and 3 columns.

After transposing, it has 3 rows and 2 columns.

Java Code
class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
10.Move Zeroes

Problem Statement

Given an integer array nums, move all the zeroes to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed in-place, meaning no separate array should be created.

Example

Input:

[0, 1, 0, 3, 12]

Output:

[1, 3, 12, 0, 0]
Explanation
The non-zero elements 1, 3, 12 remain in their original order.
All zeroes are moved to the end.
Java Code
class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;

        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill the remaining positions with zeroes
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
