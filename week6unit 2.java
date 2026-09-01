1. Circular Palindromes

Problem Statement

Given a string s, consider every possible circular rotation of the string.

For each rotation, find the length of the longest palindromic substring and return the result for all rotations.

A palindrome is a string that reads the same forward and backward.

Example

For:

s = "aaa"

Every rotation is:

"aaa"
"aaa"
"aaa"

The longest palindrome in each rotation has length 3.

Output:

[3, 3, 3]
Explanation

For each starting position:

Create a circular rotation.
Find all possible palindromic substrings.
Keep track of the longest palindrome.
Store its length in the result list.
Java Code
import java.util.*;

public class Result {

    public static List<Integer> circularPalindromes(String s) {

        int n = s.length();
        List<Integer> result = new ArrayList<>();

        // Generate every circular rotation
        for (int start = 0; start < n; start++) {

            String rotation =
                    s.substring(start) + s.substring(0, start);

            int max = 1;

            // Check every possible palindrome center
            for (int i = 0; i < n; i++) {

                // Odd-length palindrome
                int len1 = expand(rotation, i, i);

                // Even-length palindrome
                int len2 = expand(rotation, i, i + 1);

                max = Math.max(max, Math.max(len1, len2));
            }

            result.add(max);
        }

        return result;
    }

    // Expand around the center
    private static int expand(
            String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}
2.Find All Anagrams in a String

Problem Statement

Given two strings s and p, find all starting indices of substrings in s that are anagrams of p.

An anagram contains the same characters with the same frequencies, but the characters can appear in a different order.

Return a list containing the starting index of every anagram found.

Example

Input:

s = "cbaebabacd"
p = "abc"

Output:

[0, 6]
Explanation

The substrings of length 3 that are anagrams of "abc" are:

"cba" → index 0 ✓
"bac" → index 6 ✓

Therefore, the answer is:

[0, 6]
Java Code
import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Count characters in pattern
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            window[s.charAt(i) - 'a']++;

            // Remove character outside the window
            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare character frequencies
            if (Arrays.equals(pCount, window)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
3.Find All Anagrams in a String

Problem Statement

Given two strings s and p, find all starting indices of substrings in s that are anagrams of p.

An anagram contains the same characters with the same frequencies, but the characters can appear in a different order.

Return a list containing the starting index of every anagram found.

Example

Input:

s = "cbaebabacd"
p = "abc"

Output:

[0, 6]
Explanation

The substrings of length 3 that are anagrams of "abc" are:

"cba" → index 0 ✓
"bac" → index 6 ✓

Therefore, the answer is:

[0, 6]
Java Code
import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Count characters in pattern
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            window[s.charAt(i) - 'a']++;

            // Remove character outside the window
            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare character frequencies
            if (Arrays.equals(pCount, window)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
4.Longest Palindromic Substring

Problem Statement

Given a string s, find the longest substring that is a palindrome.

A palindrome is a string that reads the same forward and backward.

The substring must be contiguous, meaning all characters between the starting and ending positions are included.

Example 1

Input:

babad

Output:

bab

Explanation:
"bab" is a palindrome. "aba" is also a valid answer, but "bab" is one of the longest palindromic substrings.

Example 2

Input:

cbbd

Output:

bb

Explanation:
"bb" is the longest palindrome in the string.

Java Code
class Solution {

    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome
            int len1 = expand(s, i, i);

            // Even-length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start + 1) {

                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}
5. Mars Exploration

Problem Statement

A space explorer receives a repeated message sent from Mars. The expected message follows the pattern:

SOS SOS SOS SOS ...

Due to signal interference, some characters may have been changed.

Given the received message s, determine the number of altered characters compared with the expected repeated "SOS" pattern.

Example

Input:

SOSTOT

Output:

2
Explanation

Expected message:

SOS SOS

Received message:

SOS TOT

Comparing each character:

S O S T O T
S O S S O S
      ↑   ↑

There are 2 altered characters.

Java Code
public class Result {

    public static int marsExploration(String s) {

        String pattern = "SOS";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != pattern.charAt(i % 3)) {
                count++;
            }
        }

        return count;
    }
}
6.Palindrome Index

Problem Statement

Given a string s, find the index of the character that can be removed to make the string a palindrome.

If the string is already a palindrome, return -1.
If removing one character makes it a palindrome, return that character's index.
If no single character can make the string a palindrome, return -1.
Example 1

Input:

aaab

Output:

3

Explanation:

Remove the character at index 3 (b):

aaa

aaa is a palindrome, so the answer is 3.

Example 2

Input:

baa

Output:

0

Explanation:

Remove the character at index 0 (b):

aa

aa is a palindrome, so the answer is 0.

Example 3

Input:

aaa

Output:

-1

Explanation:
The string is already a palindrome, so no deletion is required.

Java Code
public class Result {

    public static int palindromeIndex(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                // Try removing the left character
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }

                // Try removing the right character
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }

                return -1;
            }

            left++;
            right--;
        }

        return -1;
    }

    private static boolean isPalindrome(
            String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
7.Repeated Substring Pattern

Problem Statement

Given a string s, determine whether it can be constructed by repeating one of its substrings multiple times.

The substring must:

Have a length smaller than the original string.
Repeat continuously to form the entire original string.

Return:

true if such a repeated substring exists.
false otherwise.
Example 1

Input:

abab

Output:

true

Explanation:
The substring "ab" is repeated twice:

ab + ab = abab
Example 2

Input:

aba

Output:

false

Explanation:
No smaller substring can be repeated to form "aba".

Java Code
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        // Try every possible substring length
        for (int len = 1; len <= n / 2; len++) {

            // The length must divide the string length
            if (n % len != 0) {
                continue;
            }

            String pattern = s.substring(0, len);
            StringBuilder result = new StringBuilder();

            // Repeat the substring
            for (int i = 0; i < n / len; i++) {
                result.append(pattern);
            }

            // Check if it forms the original string
            if (result.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }
}
8.Rotate String

Problem Statement

Given two strings s and goal, determine whether goal can be obtained by rotating s.

A rotation moves some characters from the beginning of s to the end while keeping the order of all characters unchanged.

Return:

true if goal is a valid rotation of s.
false otherwise.
Example 1

Input:

s = "abcde"
goal = "cdeab"

Output:

true

Explanation:

Rotate "abcde" by 2 positions:

abcde → cdeab

Therefore, goal is a valid rotation.

Example 2

Input:

s = "abcde"
goal = "abced"

Output:

false

Explanation:
"abced" cannot be obtained by rotating "abcde".

Java Code
class Solution {
    public boolean rotateString(String s, String goal) {

        // Different lengths cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }

        // A rotation will appear inside s + s
        String combined = s + s;

        return combined.contains(goal);
    }
}
9.String Similarity

Problem Statement

Given a string s, calculate the similarity score of the string.

The similarity of a string is the length of the longest common prefix between the original string s and each suffix of s.

For every position i, consider the suffix starting at i:

s[i...n-1]

Compare it with the original string s from the beginning. Count how many consecutive characters match.

Finally, return the sum of all similarity values.

Example

Input:

ababaa

Output:

11
Explanation

For s = "ababaa":

Suffix	Common Prefix Length
ababaa	6
babaa	0
abaa	3
baa	0
aa	1
a	1

Total:

6 + 0 + 3 + 0 + 1 + 1 = 11
Java Code
import java.util.*;

public class Result {

    public static long stringSimilarity(String s) {

        int n = s.length();
        long sum = 0;

        // Compare the original string
        // with every suffix
        for (int i = 0; i < n; i++) {

            int j = 0;

            while (i + j < n &&
                   s.charAt(j) == s.charAt(i + j)) {
                j++;
            }

            sum += j;
        }

        return sum;
    }
}
10.Two Strings – Common Character

Problem Statement

Given two strings s1 and s2, determine whether they share at least one common character.

If any character appears in both strings, return "YES". Otherwise, return "NO".

The strings contain lowercase English letters.

Example 1

Input:

s1 = "hello"
s2 = "world"

Output:

YES

Explanation:
Both strings contain the character o.

Example 2

Input:

s1 = "hi"
s2 = "world"

Output:

NO

Explanation:
There is no character common to both strings.

Java Code
import java.util.*;

public class Result {

    public static String twoStrings(String s1, String s2) {

        boolean[] seen = new boolean[26];

        // Store characters from first string
        for (char c : s1.toCharArray()) {
            seen[c - 'a'] = true;
        }

        // Check characters of second string
        for (char c : s2.toCharArray()) {

            if (seen[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }
}
