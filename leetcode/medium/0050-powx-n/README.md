# Pow(x, n)

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Implement pow(x, n), which calculates `x` raised to the power `n` (i.e., `xn`).

 

 **Example 1:** 

```
Input: x = 2.00000, n = 10
Output: 1024.00000

```

 **Example 2:** 

```
Input: x = 2.10000, n = 3
Output: 9.26100

```

 **Example 3:** 

```
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

```

 

 **Constraints:** 

- -100.0 < x < 100.0
- -231 <= n <= 231-1
- n is an integer.
- Either x is not zero or n > 0.
- -104 <= xn <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 43.8 MB  
**Submitted:** 2026-10-20T17:23:26.938Z  

```java
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double ans = 1;
        double currentProduct = x;
        
        while (N > 0) {
            if (N % 2 == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
            N = N / 2;
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/powx-n/)