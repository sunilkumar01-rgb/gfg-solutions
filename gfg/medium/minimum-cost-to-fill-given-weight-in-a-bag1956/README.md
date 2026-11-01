# Minimum Cost to Fill Given Weight

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a bag of size w kg and you are provided costs of packets different weights of oranges in array cost[], find the minimum total cost to buy exactly w kg oranges

- The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
- cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
- If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite supply of all available packet types.

 **Examples:** 

```
Input: cost[] = [20, 10, 4, 50, 100], w = 5
Output: 14
Explanation: The minimum cost is 14 by purchasing a 2kg packet for 10 and a 3kg packet for 4.
```

```
Input: cost[] = [-1, -1, 4, 3, -1], w = 5
Output: -1
Explanation: It is not possible to buy 5 kgs.
```

 **Constraints:** 
1 ≤ cost.size(), w ≤ 2*103
1 ≤ cost[i] ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:25:37.274Z  

```java
class Solution {
    public int minimumCost(int[] cost, int w) {

        int n = cost.length;
        int INF = 1_000_000_000;

        int[] dp = new int[w + 1];
        dp[0] = 0;

        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }

        for (int weight = 1; weight <= w; weight++) {

            for (int i = 0; i < n && i < weight; i++) {

                if (cost[i] != -1 &&
                    dp[weight - (i + 1)] != INF) {

                    dp[weight] = Math.min(
                        dp[weight],
                        dp[weight - (i + 1)] + cost[i]
                    );
                }
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1)