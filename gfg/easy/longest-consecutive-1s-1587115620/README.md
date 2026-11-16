# Longest Consecutive 1's

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a number  **n.** Find the length of the longest consecutive 1s in its binary representation.

 **Examples:** 

```
Input: n = 14
Output: 3
Explanation: Binary representation of 14 is 1110, in which 111 is the longest consecutive set bits of length is 3.
```

```
Input: n = 222
Output: 4
Explanation: Binary representation of 222 is 11011110, in which 1111 is the longest consecutive set bits of length 4. 

```

 **Constraints :** 
 1  ≤ n ≤ 109

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-16T16:09:50.670Z  

```java
class Solution {
    public int maxConsecutiveOnes(int n) {

        int count = 0;
        int maxCount = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }

            n = n >> 1;
        }

        return maxCount;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1)