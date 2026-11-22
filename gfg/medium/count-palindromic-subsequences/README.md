# Count Palindromic Subsequences

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string  **s**, you have to find the number of palindromic subsequences (need not necessarily be distinct) present in the string s. 

 **Examples:** 

```
Input: s = "abcd"
Output: 4
Explanation: palindromic subsequence are : 'a','b', 'c','d'
```

```
Input: s = "aab"
Output: 4
Explanation: palindromic subsequence are : 'a', 'a', 'b', 'aa'

```

```
Input: s = "b"
Output: 1
Explanation: palindromic subsequence are : 'b'
```

 **Constraints:** 
1<= s.size() <=30

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T17:03:36.733Z  

```java
class Solution {
    long MOD = 1000000007;

    long countPS(String str) {
        int n = str.length();
        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int gap = 1; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % MOD;
                } else {
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + MOD) % MOD;
                }
            }
        }

        return dp[0][n - 1];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1)