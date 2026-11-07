# Best Time to Buy and Sell Stock with Cooldown

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

- After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).

 **Note:**  You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

 **Example 1:** 

```
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

```

 **Example 2:** 

```
Input: prices = [1]
Output: 0

```

 

 **Constraints:** 

- 1 <= prices.length <= 5000
- 0 <= prices[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.9 MB (beats 91.66%)  
**Submitted:** 2026-11-07T17:12:38.491Z  

```java
class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0;     // Max profit if we just sold today
        int held = Integer.MIN_VALUE; // Max profit if we hold a stock
        int rest = 0;     // Max profit if we are in cooldown/rest
        
        for (int price : prices) {
            int prevSold = sold;
            
            // Aaj bechne par profit: kal tak hold kiya hua tha + aaj ka price
            sold = held + price;
            
            // Aaj hold karne par: ya toh kal se hold kar rahe the, ya aaj rest ke baad kharida
            held = Math.max(held, rest - price);
            
            // Aaj rest karne par: ya toh kal sold kiya tha (cooldown), ya kal se rest kar rahe the
            rest = Math.max(rest, prevSold);
        }
        
        return Math.max(sold, rest);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)