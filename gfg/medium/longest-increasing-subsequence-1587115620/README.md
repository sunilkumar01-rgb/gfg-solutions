# Longest Increasing Subsequence

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of non-negative integers, find the length of the Longest Strictly Increasing Subsequence (LIS). A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

 **Examples:** 

```
Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
```

```
Input: arr[] = [10, 6, 3, 11, 7, 15]
Output: 3
Explanation: One of the possible longest strictly increasing subsequences is [10, 11, 15], which has a length of 3.
```

```
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T17:32:03.928Z  

```java
class Solution {
    public int lis(int arr[]) {
        if (arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1)