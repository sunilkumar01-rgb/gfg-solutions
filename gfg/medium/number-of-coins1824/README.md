# Coin Change (Minimum Coins)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **coins[]**, where each element represents a coin of a different denomination, and a target value  **sum**. You have an unlimited supply of each coin type.

Find the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

 **Examples:** 

``` Input: coins[] = [25, 10, 5], sum = 30 Output: 2 Explanation: Minimum 2 coins needed, 25 and 5   ```
``` Input: coins[] = [9, 6, 5, 1], sum = 19 Output: 3 Explanation: 19 = 9 + 9 + 1 ```
``` Input: coins[] = [5, 1], sum = 0 Output: 0 Explanation: For 0 sum, we do not need a coin ```
``` Input: coins[] = [4, 6, 2], sum = 5 Output: -1 Explanation: Not possible to make the given sum. ```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T16:57:35.364Z  

```java
class Solution {
    public int minCoins(int coins[], int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[sum] > sum ? -1 : dp[sum];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-coins1824/1)