# Nth Root of M

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not integer then return -1.

 **Examples :** 

```
Input: n = 3, m = 8
Output: 2
Explanation: 23 = 8

```

```
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not integer.
```

```
Input: n = 4, m = 16
Output: 2
Explanation: 24 = 16
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-22T17:07:30.517Z  

```java
class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0) return 0; // Edge case
        if (m == 1) return 1;

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = 1;

            for (int i = 0; i < n; i++) {
                power *= mid;
                if (power > m) break; // Overflow aur TLE se bachne ke liye
            }

            if (power == m) return mid;
            else if (power < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1)