# Longest Palindromic Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**, return the  **length** of the longest palindromic subsequence.
A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
A palindromic sequence is a sequence that reads the same forward and backward.

 **Examples:** 

```
Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.

```

```
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.

```

```
Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
```

 **Constraints:** 
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T16:54:37.374Z  

```java
class Solution {
    public int longestPalinSubseq(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (S.charAt(i) == S.charAt(j) && cl == 2) {
                    dp[i][j] = 2;
                } else if (S.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1)