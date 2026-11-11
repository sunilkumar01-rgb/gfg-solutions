# Travelling Salesman Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a 2d matrix  **cost[][],**  where cost[i][j] denotes the cost of moving from city i to city j. Your task is to complete a tour from city 0 (0-based index) to all other cities such that you visit each city exactly once and then at the end come back to city 0 at minimum cost.

 **Examples:** 

```
Input: cost[][] = [[0, 111], [112, 0]]
Output: 223
Explanation: We can visit 0->1->0 and cost = 111 + 112.

```

```
Input: cost[][] = [[0, 1000, 5000], [5000, 0, 1000], [1000, 5000, 0]]
Output: 3000
Explanation: We can visit 0->1->2->0 and cost = 1000 + 1000 + 1000 = 3000

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T16:17:50.502Z  

```java
class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int fullMask = (1 << n) - 1;

        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, 0, cost, dp, fullMask);
    }

    private int solve(int mask, int pos, int[][] cost,
                      int[][] dp, int fullMask) {

        if (mask == fullMask) {
            return cost[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < cost.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = cost[pos][city] +
                    solve(mask | (1 << city), city, cost, dp, fullMask);

                ans = Math.min(ans, newCost);
            }
        }

        return dp[mask][pos] = ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/travelling-salesman-problem2732/1)