# K-Palindrome

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a string  **s**  and an integer  **k**, find if it is k-palindrome or not. A string is called a k-palindrome if it can be transformed into a palindrome by removing at most k characters.

 **Examples:** 

```
Input: s = "abcdecba", k = 1
Output: true
Explanation: By removing 'd' or 'e' we can make it a palindrome. Therefore answer is true for this test case.
```

```
Input: s = "abcdefcba", k = 1
Output: false
Explanation: By removing a single character we cannot make it a palindrome.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:30:25.506Z  

```java
class Solution {
    public boolean kPalindrome(String s, int k) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n + 1][n + 1];

        // Find the Longest Common Subsequence (LCS)
        // between the string and its reverse.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        int minDeletions = n - dp[n][n];

        return minDeletions <= k;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-if-string-is-k-palindrome-or-not1923/1)