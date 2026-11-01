# Optimal Strategy for Game

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array  **arr[]** of size n. The array elements represent n coins of values v1, v2,....vn.
You play against an opponent in an alternating way. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the coin's value.
Find the maximum possible amount of money you can win if you go first.
 **Note:**  Both the players are playing optimally.

 **Examples:** 

```
Input: arr[] = [5, 3, 7, 10]
Output: 15
Explanation: The user collects the maximum value as 15(10 + 5). It is guaranteed that we cannot get more than 15 by any possible moves.

```

```
Input: arr[] = [8, 15, 3, 7]
Output: 22
Explanation: The user collects the maximum value as 22(7 + 15). It is guaranteed that we cannot get more than 22 by any possible moves.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:24:09.076Z  

```java
class Solution {
    public int maximumAmount(int arr[]) {

        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                int x = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int y = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int z = (i <= j - 2) ? dp[i][j - 2] : 0;

                dp[i][j] = Math.max(
                    arr[i] + Math.min(x, y),
                    arr[j] + Math.min(y, z)
                );
            }
        }

        return dp[0][n - 1];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1)