# Partition Equal Subset Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return `true`  *if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or* `false` *otherwise*.

 

Original
Java
 **Example 1:** 

```
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

```

 **Example 2:** 

```
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

```

 

 **Constraints:** 

- 1 <= nums.length <= 200
- 1 <= nums[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 31 ms (beats 80.92%)  
**Memory:** 43.2 MB (beats 96.35%)  
**Submitted:** 2026-11-13T16:28:44.281Z  

```java
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/partition-equal-subset-sum/)