# Maximum XOR of two numbers in an array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of non-negative integers of size  **n**. Find the maximum possible  **XOR**  between two numbers present in the array.

 **Examples:** 

```
Input: arr[] = [25, 10, 2, 8, 5, 3]
Output: 28
Explanation: The maximum possible XOR is 5 ^ 25 = 28.

```

```
Input: arr[] = [1, 2, 3, 4, 5, 6, 7]
Output: 7
Explanation : The maximum possible XOR is 1 ^ 6 = 7.
```

 **Constraints:** 
2 ≤ arr.size() ≤ 5*104
1 ≤ arr[i] ≤ 106

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T20:14:22.468Z  

```java
class Solution {
    public int maxXor(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[i] ^ arr[j]);
            }
        }

        return max;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-xor-of-two-numbers-in-an-array/1)