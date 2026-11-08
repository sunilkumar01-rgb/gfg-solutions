# Count of Range Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and two integers `lower` and `upper`, return  *the number of range sums that lie in*  `[lower, upper]`  *inclusive*.

Range sum `S(i, j)` is defined as the sum of the elements in `nums` between indices `i` and `j` inclusive, where `i <= j`.

 

 **Example 1:** 

```
Input: nums = [-2,5,-1], lower = -2, upper = 2
Output: 3
Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.

```

 **Example 2:** 

```
Input: nums = [0], lower = 0, upper = 0
Output: 1

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -231 <= nums[i] <= 231 - 1
- -105 <= lower <= upper <= 105
- The answer is guaranteed to fit in a 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 58 ms (beats 57.45%)  
**Memory:** 79.9 MB (beats 73.39%)  
**Submitted:** 2026-11-08T16:53:09.873Z  

```java
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, n, lower, upper);
    }
    
    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(prefix, left, mid, lower, upper) + 
                    mergeSort(prefix, mid + 1, right, lower, upper);
        
        int j = mid + 1, k = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && prefix[j] - prefix[i] < lower) j++;
            while (k <= right && prefix[k] - prefix[i] <= upper) k++;
            count += k - j;
        }
        
        long[] temp = new long[right - left + 1];
        int i = left, p = mid + 1, t = 0;
        while (i <= mid && p <= right) {
            if (prefix[i] <= prefix[p]) temp[t++] = prefix[i++];
            else temp[t++] = prefix[p++];
        }
        while (i <= mid) temp[t++] = prefix[i++];
        while (p <= right) temp[t++] = prefix[p++];
        System.arraycopy(temp, 0, prefix, left, temp.length);
        
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/count-of-range-sum/)