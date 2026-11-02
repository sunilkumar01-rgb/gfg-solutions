# Palindrome Partitioning II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string `s`, partition `s` such that every substring of the partition is a palindrome.

Return  *the  **minimum**  cuts needed for a palindrome partitioning of*  `s`.

 

 **Example 1:** 

```
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

```

 **Example 2:** 

```
Input: s = "a"
Output: 0

```

 **Example 3:** 

```
Input: s = "ab"
Output: 1

```

 

 **Constraints:** 

- 1 <= s.length <= 2000
- s consists of lowercase English letters only.

## Solution

**Language:** Java  
**Runtime:** 30 ms (beats 74.05%)  
**Memory:** 47.3 MB (beats 51.13%)  
**Submitted:** 2026-11-02T13:01:35.784Z  

```java
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return n == 0 ? 0 : dp[n - 1];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-partitioning-ii/)