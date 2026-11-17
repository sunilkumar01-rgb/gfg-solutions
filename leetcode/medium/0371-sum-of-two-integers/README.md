# Sum of Two Integers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integers `a` and `b`, return  *the sum of the two integers without using the operators*  `+`  *and*  `-`.

 

Original
Java
 **Example 1:** 

```
Input: a = 1, b = 2
Output: 3

```

 **Example 2:** 

```
Input: a = 2, b = 3
Output: 5

```

 

 **Constraints:** 

- -1000 <= a, b <= 1000

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 41.3 MB (beats 93.07%)  
**Submitted:** 2026-11-17T17:27:08.793Z  

```java
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // carry nikalna
            int carry = (a & b) << 1;
            // bina carry ke sum nikalna
            a = a ^ b;
            // carry ko next iteration ke liye bhejna
            b = carry;
        }
        return a;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/sum-of-two-integers/)