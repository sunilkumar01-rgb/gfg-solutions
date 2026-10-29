# Count Set Bits in 1 to n

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a number **n**. Return the total count of set bits for all numbers from 1 to n (both inclusive).

**Examples :
**

```
Input: n = 4
Output: 5
Explanation: For numbers from 1 to 4. for 1: 0 0 1 => 1 set bit, for 2: 0 1 0 => 1 set bit, for 3: 0 1 1 => 2 set bits, for 4: 1 0 0 => 1 set bit. Therefore, the total set bits are 5.

```

```
Input: n = 17
Output: 35
Explanation: From numbers 1 to 17(both inclusive), the total number of set bits are 35.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T16:07:43.630Z  

```java
class Solution {
    public static int countSetBits(int n) {
        if (n == 0) {
            return 0;
        }

        int x = 0;
        while ((1 << (x + 1)) <= n) {
            x++;
        }

        return (x * (1 << (x - 1)))
             + (n - (1 << x) + 1)
             + countSetBits(n - (1 << x));
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1)