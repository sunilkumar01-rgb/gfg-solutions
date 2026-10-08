# Stock Buy and Sell

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

 **Note:** We can only sell a stock which we have bought earlier and only one instance of stock can be traded.

 **Examples:** 

```
Input: arr[] = [100, 180, 260, 310, 40, 535, 695]
Output: 865
Explanation: Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210 Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655 Maximum Profit  = 210 + 655 = 865
```

```
Input: arr[] = [4, 2, 2, 2, 4]
Output: 2
Explanation: Buy the stock on day 3 and sell it on day 4 => 4 – 2 = 2

```

```
Input: arr[] = [4, 2]
Output: 0
Explanation: Don't Buy the stock.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-08T17:31:43.255Z  

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        long profit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }

        return (int) profit;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1)