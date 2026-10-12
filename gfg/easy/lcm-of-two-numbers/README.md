# LCM of Two Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two positive integers  **a**  and  **b**, find the Least Common Multiple (LCM) of the two numbers.

 **Examples:** 

```
Input: a = 12, b = 18
Output: 36
Explanation: LCM of 12 and 18 is 36
```

```
Input: a = 5, b = 11
Output: 55
Explanation: LCM of 5 and 11 is 55
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-12T17:26:58.792Z  

```java
class Solution {
    static int lcm(int a, int b) {
        int x = a, y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;
        return (a / gcd) * b;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/lcm-of-two-numbers/1)