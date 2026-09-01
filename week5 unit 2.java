1. Alternating Characters

Problem Statement

Given a string s containing only the characters A and B, find the minimum number of characters that must be deleted so that no two adjacent characters are the same.

The final string should follow an alternating pattern such as:

ABABAB

or

BABABA
Example

Input:

AABAAB

Output:

2

Explanation:

AA contains two consecutive As → delete one A.
Another AA occurs later → delete one A.
The resulting string is ABAB.

Therefore, the minimum number of deletions is 2.

Java Code
import java.util.*;

public class Result {

    public static int alternatingCharacters(String s) {

        int count = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
        }

        return count;
    }
}
2.Find and Replace Pattern

Problem Statement

Given an array of strings words and a string pattern, find all words that match the same pattern.

A word matches the pattern if there is a one-to-one mapping between the characters of the word and the characters of the pattern.

The same character must always map to the same character, and two different characters cannot map to the same character.

Example

Input:

words = ["abc", "deq", "mee", "aqq", "dkd", "ccc"]
pattern = "abb"

Output:

["mee", "aqq"]
Explanation

Pattern: abb

mee → m → a, e → b ✅
aqq → a → a, q → b ✅
abc → a → a, b → b, c → b ❌ because b and c cannot map to the same character.
Java Code
import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(
            String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {

            char w = word.charAt(i);
            char p = pattern.charAt(i);

            // Check word character mapping
            if (map1.containsKey(w) && map1.get(w) != p) {
                return false;
            }

            // Check pattern character mapping
            if (map2.containsKey(p) && map2.get(p) != w) {
                return false;
            }

            map1.put(w, p);
            map2.put(p, w);
        }

        return true;
    }
}
3.Longest Substring Without Repeating Characters

Problem Statement

Given a string s, find the length of the longest substring that contains no repeated characters.

A substring must contain characters in continuous order.

Example 1

Input:

abcabcbb

Output:

3

Explanation:
The longest substring without repeating characters is "abc", which has a length of 3.

Example 2

Input:

bbbbb

Output:

1

Explanation:
Only "b" can be used because every other character is repeated.

Example 3

Input:

pwwkew

Output:

3

Explanation:
The longest substring is "wke", with length 3.

Java Code
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
4.Maximum Subarray – Maximum Subarray Sum and Maximum Subsequence Sum

Problem Statement

Given an array of integers, find two values:

Maximum Subarray Sum: The maximum sum of a contiguous subarray.
Maximum Subsequence Sum: The maximum sum that can be obtained by selecting elements in their original order, without requiring them to be contiguous.

If all elements are negative, the maximum subsequence sum should be the largest single element.

Example

Input:

[-1, 2, 3, -4, 5, 6]

Output:

[12, 16]
Explanation

Maximum Subarray:

2 + 3 - 4 + 5 + 6 = 12

So, maximum subarray sum = 12.

Maximum Subsequence:

Choose all positive values:

2 + 3 + 5 + 6 = 16

So, maximum subsequence sum = 16.

Java Code
import java.util.*;

public class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int current = arr.get(0);
        int maxSub = arr.get(0);

        int maxNon = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {

            int x = arr.get(i);

            // Maximum contiguous subarray sum
            current = Math.max(x, current + x);
            maxSub = Math.max(maxSub, current);

            // Maximum subsequence sum
            maxNon = Math.max(maxNon, maxNon + Math.max(0, x));
        }

        return Arrays.asList(maxSub, maxNon);
    }
}
5.Maximum Subarray

Problem Statement

Given an integer array nums, find the contiguous subarray with the largest sum and return its sum.

A contiguous subarray contains elements that are next to each other in the array.

Example

Input:

[-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output:

6

Explanation:

The maximum subarray is:

[4, -1, 2, 1]

Its sum is:

4 + (-1) + 2 + 1 = 6

Therefore, the maximum subarray sum is 6.

Java Code
class Solution {
    public int maxSubArray(int[] nums) {

        int current = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

            current = Math.max(nums[i], current + nums[i]);

            max = Math.max(max, current);
        }

        return max;
    }
}
6. Maximum Sum Circular Subarray

Problem Statement

Given a circular integer array nums, find the maximum possible sum of a non-empty subarray.

Since the array is circular, the subarray can wrap from the end of the array back to the beginning.

For example:

[5, -3, 5]

The maximum circular subarray is:

[5, 5]

with a sum of 10.

Example

Input:

[5, -3, 5]

Output:

10
Explanation

There are two possibilities:

Normal maximum subarray: 5 + (-3) + 5 = 7
Circular maximum subarray: 5 + 5 = 10

Therefore, the answer is 10.

Java Code
class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;

        int currentMax = nums[0];
        int maxSum = nums[0];

        int currentMin = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            total += nums[i];

            if (i > 0) {

                // Maximum normal subarray
                currentMax = Math.max(
                    nums[i],
                    currentMax + nums[i]
                );

                maxSum = Math.max(maxSum, currentMax);

                // Minimum subarray
                currentMin = Math.min(
                    nums[i],
                    currentMin + nums[i]
                );

                minSum = Math.min(minSum, currentMin);
            }
        }

        // All elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of normal and circular subarray
        return Math.max(maxSum, total - minSum);
    }
}
7.Naive Pattern Searching

Problem Statement

Given a text string and a pattern string, find all positions where the pattern occurs in the text.

The program compares the pattern with the text character by character at every possible starting position.

Whenever the complete pattern matches, print its starting index.

Example

Input:

Text = "AABAACAADAABAABA"
Pattern = "AABA"

Output:

Pattern found at index 0
Pattern found at index 9
Pattern found at index 12
Explanation

The pattern "AABA" occurs in the text starting at indexes:

0
9
12

Therefore, all three indexes are printed.

Java Code
public class Main {

    public static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        // Check every possible starting position
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            // Compare pattern with text
            while (j < m &&
                   text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            }

            // Complete pattern matched
            if (j == m) {
                System.out.println(
                    "Pattern found at index " + i
                );
            }
        }
    }

    public static void main(String[] args) {

        String text = "AABAACAADAABAABA";
        String pattern = "AABA";

        search(text, pattern);
    }
}
8.String Matching in an Array

Problem Statement

Given an array of strings words, find all strings that are substrings of another string in the same array.

A string words[i] is considered a match if there exists another string words[j] such that:

words[j].contains(words[i])

The matching strings should be returned in a list.

Example

Input:

["mass", "as", "hero", "superhero"]

Output:

["as", "hero"]
Explanation
"as" is a substring of "mass" → ✅
"hero" is a substring of "superhero" → ✅
"mass" is not a substring of another word → ❌
"superhero" is not a substring of another word → ❌

Therefore, the result is:

["as", "hero"]
Java Code
import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {

            for (int j = 0; j < words.length; j++) {

                // Check if words[i] is inside another word
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}
9.String to Integer (atoi)

Problem Statement

Given a string s, convert it into a 32-bit signed integer according to the rules of the atoi function.

Rules
Ignore leading whitespace characters.
Check for an optional sign:
+ means positive.
- means negative.
Read consecutive numeric digits and form the integer.
Stop reading when a non-digit character is encountered.
If the number exceeds the 32-bit signed integer range:
Return Integer.MAX_VALUE (2147483647) for positive overflow.
Return Integer.MIN_VALUE (-2147483648) for negative overflow.
If there are no digits, return 0.
Example 1

Input:

"42"

Output:

42
Example 2

Input:

"   -42"

Output:

-42
Example 3

Input:

"4193 with words"

Output:

4193
Java Code
class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Remove leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        int result = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Check integer overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1
                    ? Integer.MAX_VALUE
                    : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
10.Subarray Division – Birthday Chocolate

Problem Statement

Lily wants to divide a chocolate bar among her friends. The chocolate is represented by a list of integers, where each integer represents a chocolate square.

She needs to find the number of contiguous segments that satisfy two conditions:

The segment contains exactly m squares.
The sum of those m squares is exactly d.

Return the number of possible segments.

Example

Input:

s = [2, 2, 1, 3, 2]
d = 4
m = 2

Output:

2
Explanation

Check every consecutive segment of length 2:

[2, 2] → 4  ✓
[2, 1] → 3  ✗
[1, 3] → 4  ✓
[3, 2] → 5  ✗

There are 2 valid segments.

Java Code
import java.util.*;

public class Result {

    public static int birthday(List<Integer> s, int d, int m) {

        int count = 0;

        // Check every possible segment
        for (int i = 0; i <= s.size() - m; i++) {

            int sum = 0;

            // Calculate sum of m consecutive elements
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            // Check if sum matches d
            if (sum == d) {
                count++;
            }
        }

        return count;
    }
}
