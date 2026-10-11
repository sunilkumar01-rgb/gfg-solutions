# Max Circular Subarray Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given a circular array  **`arr[]`** of integers, find the  **maximum**  possible sum of a non-empty  **subarray**. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

 **Examples:** 

```
Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
```

```
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].

```

```
Input: arr[] = [5, -2, 3, 4]
Output: 12
Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-11T17:41:33.010Z  

```java
class Solution {
    public int maxCircularSum(int[] arr) {
        int n = arr.length;
        int total = arr[0];

        int maxKadane = arr[0], currMax = arr[0];
        int minKadane = arr[0], currMin = arr[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxKadane = Math.max(maxKadane, currMax);

            currMin = Math.min(arr[i], currMin + arr[i]);
            minKadane = Math.min(minKadane, currMin);

            total += arr[i];
        }

        if (maxKadane < 0) return maxKadane;

        return Math.max(maxKadane, total - minKadane);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1)