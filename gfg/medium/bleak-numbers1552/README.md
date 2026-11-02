# Bleak Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer  **n**, check whether it is Bleak or not. A number n is called Bleak if it cannot be represented as sum of a positive number x and set bit count in x, i.e., x + countSetBits(x) is not equal to n for any non-negative number x.

 **Examples:** 

```
Input: n = 4
Output: true
Explanation: There is no x such that x + countSetbit(x) = 4.

```

```
Input: n = 3
Output: false
Explanation: 3 is not a Bleak number as 2 + countSetBit(2) = 3.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-02T13:09:19.556Z  

```java
class Solution {
    public boolean isBleak(int n) {
        int start = Math.max(1, n - 30);

        for (int x = start; x < n; x++) {
            if (x + Integer.bitCount(x) == n) {
                return false;
            }
        }

        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bleak-numbers1552/1)