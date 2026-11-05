# Split Array Largest Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty subarrays such that the largest sum of any subarray is  **minimized**.

Return  *the minimized largest sum of the split*.

A  **subarray**  is a contiguous part of the array.

 

 **Example 1:** 

```
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

```

 **Example 2:** 

```
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

```

 

 **Constraints:** 

- 1 <= nums.length <= 1000
- 0 <= nums[i] <= 106
- 1 <= k <= min(50, nums.length)

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.1 MB (beats 98.86%)  
**Submitted:** 2026-11-05T16:23:39.684Z  

```java
class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        long sum = 0;
        
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        long left = max, right = sum;
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (isValid(nums, k, mid)) {
                ans = mid;
                right = mid - 1; // Try to minimize the largest sum
            } else {
                left = mid + 1; // Need more capacity
            }
        }
        return (int) ans;
    }
    
    private boolean isValid(int[] nums, int k, long maxSum) {
        int count = 1;
        long currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                count++;
                currentSum = num;
                if (count > k) return false;
            }
        }
        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/split-array-largest-sum/)