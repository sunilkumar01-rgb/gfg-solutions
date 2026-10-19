# Trailing Zeroes in Factorial

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

For an integer  **n,**  find the number of trailing zeroes in  **n!.** 

 **Examples :** 

```
Input: n = 5
Output: 1
Explanation: 5! = 120 so the number of trailing zero is 1.
```

```
Input: n = 4
Output: 0
Explanation: 4! = 24 so the number of trailing zero is 0.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-19T17:02:56.311Z  

```java
class Solution {
    static int trailingZeroes(int N) {
        int count = 0;
        while (N > 0) {
            N /= 5;
            count += N;
        }
        return count;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/trailing-zeroes-in-factorial5134/1)