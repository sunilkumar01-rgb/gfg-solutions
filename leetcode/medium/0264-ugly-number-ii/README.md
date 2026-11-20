# Ugly Number II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

An  **ugly number**  is a positive integer whose prime factors are limited to `2`, `3`, and `5`.

Given an integer `n`, return  *the*  `nth`  ***ugly number** *.

 

Original
Java
 **Example 1:** 

```
Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.

```

 **Example 2:** 

```
Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

```

 

 **Constraints:** 

- 1 <= n <= 1690

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 67.17%)  
**Memory:** 42.7 MB (beats 92.90%)  
**Submitted:** 2026-11-20T17:44:08.297Z  

```java
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int i2 = 0, i3 = 0, i5 = 0;
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            ugly[i] = nextUgly;
            
            if (nextUgly == ugly[i2] * 2) i2++;
            if (nextUgly == ugly[i3] * 3) i3++;
            if (nextUgly == ugly[i5] * 5) i5++;
        }
        
        return ugly[n - 1];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/ugly-number-ii/)