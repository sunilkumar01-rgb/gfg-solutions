# Subset Sum Divisible by k

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** of positive integers and a value  **k**, check if sum of any non-empty subset of the given array is divisible by k.

 **Examples:** 

```
Input: arr[] = [3, 1, 7, 5], k = 6
Output: true
Explanation: If we take the subset {7, 5} then sum will be 12 which is divisible by 6.

```

```
Input: arr[] = [1, 2, 6], k = 5
Output: false
Explanation: All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-06T18:31:19.043Z  

```java
class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;

        if (n >= k) return true;

        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] newDp = new boolean[k];
            newDp[num % k] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    newDp[r] = true;
                    newDp[(r + num % k) % k] = true;
                }
            }
            dp = newDp;

            if (dp[0]) return true;
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m2546/1)