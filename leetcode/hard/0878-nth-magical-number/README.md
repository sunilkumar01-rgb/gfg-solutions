# Nth Magical Number

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

A positive integer is  *magical*  if it is divisible by either `a` or `b`.

Given the three integers `n`, `a`, and `b`, return the `nth` magical number. Since the answer may be very large,  **return it modulo** `109 + 7`.

 

 **Example 1:** 

```
Input: n = 1, a = 2, b = 3
Output: 2

```

 **Example 2:** 

```
Input: n = 4, a = 2, b = 3
Output: 6

```

 

 **Constraints:** 

- 1 <= n <= 109
- 2 <= a, b <= 4 * 104

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 41.3 MB (beats 99.31%)  
**Submitted:** 2026-10-29T20:10:24.665Z  

```java
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1_000_000_007;
        long lcm = (long) a / gcd(a, b) * b;
        
        long left = Math.min(a, b);
        long right = (long) n * Math.min(a, b);
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            
            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) (left % MOD);
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/nth-magical-number/)