# K-th Smallest in Lexicographical Order

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given two integers `n` and `k`, return  *the*  `kth`  *lexicographically smallest integer in the range*  `[1, n]`.

 

Original
Java
 **Example 1:** 

```
Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

```

 **Example 2:** 

```
Input: n = 1, k = 1
Output: 1

```

 

 **Constraints:** 

- 1 <= k <= n <= 109

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 41.1 MB (beats 99.32%)  
**Submitted:** 2026-11-26T16:51:49.434Z  

```java
class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // 1-based se 0-based index me convert kiya
        
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/)