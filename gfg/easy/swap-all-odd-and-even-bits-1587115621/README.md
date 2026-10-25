# Swap  Odd and Even Bits

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an unsigned integer  **n**, You have  to swap all even-position bits with their rightside adjacent odd-position bits.

 **Examples:** 

```
Input: n = 23
Output: 43
Explanation: Binary representation of the given number  is 00010111 after swapping  00101011 = 43 in decimal.
```

```
Input: n = 2
Output: 1
Explanation: Binary representation of the given number is 10 after swapping 01 = 1 in decimal.

```

**Constraints:
**1 ≤ n ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-25T17:24:22.399Z  

```java
class Solution {
    public int swapBits(int n) {
        return ((n & 0xAAAAAAAA) >>> 1) |
               ((n & 0x55555555) << 1);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits-1587115621/1)