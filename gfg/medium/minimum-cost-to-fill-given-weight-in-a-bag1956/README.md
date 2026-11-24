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
**Submitted:** 2026-11-24T17:03:24.744Z  

```java
import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];

        // dp array ko infinity se initialize karo
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 weight ke liye 0 cost

        // Standard Unbounded Knapsack logic
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                // Agar current packet available hai aur uski weight i se kam/barabar hai
                if (j <= i && cost[j - 1] != -1 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + cost[j - 1]);
                }
            }
        }

        // Agar dp[w] infinity hi raha, matlab exact weight banana possible nahi hai
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1)