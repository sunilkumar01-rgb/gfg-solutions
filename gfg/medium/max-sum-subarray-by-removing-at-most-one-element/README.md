# Max Subarray Sum by Removing At Most One

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array arr[], find the maximum sum of a non-empty subarray. You are allowed to skip at most one element in the subarray.

 **Note:**  After skipping the element, the subarray must still be non-empty.

 **Examples:** 

```
Input: arr[] = [1, 2, 3, -4, 5]
Output: 11
Explanation: We can get maximum sum subarray by skipping -4.
```

```
Input: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
Output: 9
Explanation: We can get maximum sum subarray by skipping -2 as [4,-1,1,5] sums to 9, which is the maximum achievable sum.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 106
-103 ≤ arr[i] ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-07T17:26:51.172Z  

```java
class Solution {
    public int maxSumSubarray(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = 0;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int prevNoDelete = noDelete;

            noDelete = Math.max(arr[i], noDelete + arr[i]);
            oneDelete = Math.max(prevNoDelete, oneDelete + arr[i]);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/max-sum-subarray-by-removing-at-most-one-element/1)