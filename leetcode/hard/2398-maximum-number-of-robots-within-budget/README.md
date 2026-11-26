# Maximum Number of Robots Within Budget

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You have `n` robots. You are given two  **0-indexed**  integer arrays, `chargeTimes` and `runningCosts`, both of length `n`. The `ith` robot costs `chargeTimes[i]` units to charge and costs `runningCosts[i]` units to run. You are also given an integer `budget`.

The  **total cost**  of running `k` chosen robots is equal to `max(chargeTimes) + k * sum(runningCosts)`, where `max(chargeTimes)` is the largest charge cost among the `k` robots and `sum(runningCosts)` is the sum of running costs among the `k` robots.

Return *the  **maximum**  number of  **consecutive**  robots you can run such that the total cost  **does not**  exceed* `budget`.

 

Original
Java
 **Example 1:** 

```
Input: chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
Output: 3
Explanation: 
It is possible to run all individual and consecutive pairs of robots within budget.
To obtain answer 3, consider the first 3 robots. The total cost will be max(3,6,1) + 3  *sum(2,1,3) = 6 + 3*  6 = 24 which is less than 25.
It can be shown that it is not possible to run more than 3 consecutive robots within budget, so we return 3.

```

 **Example 2:** 

```
Input: chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
Output: 0
Explanation: No robot can be run that does not exceed the budget, so we return 0.

```

 

 **Constraints:** 

- chargeTimes.length == runningCosts.length == n
- 1 <= n <= 5 * 104
- 1 <= chargeTimes[i], runningCosts[i] <= 105
- 1 <= budget <= 1015

## Solution

**Language:** Java  
**Runtime:** 24 ms (beats 85.83%)  
**Memory:** 70.7 MB (beats 78.54%)  
**Submitted:** 2026-11-26T16:54:34.478Z  

```java
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        long runningSum = 0;
        int maxRobots = 0;
        
        for (int right = 0; right < n; right++) {
            // Monotonic Deque maintain karo max charge time ke liye
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            runningSum += runningCosts[right];
            
            // Agar cost budget se bahar hai, toh window shrink karo
            while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (runningSum * (right - left + 1)) > budget) {
                runningSum -= runningCosts[left];
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }
                left++;
            }
            
            maxRobots = Math.max(maxRobots, right - left + 1);
        }
        return maxRobots;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-number-of-robots-within-budget/)