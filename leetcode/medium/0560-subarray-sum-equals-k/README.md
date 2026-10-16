# Subarray Sum Equals K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` and an integer `k`, return  *the total number of subarrays whose sum equals to*  `k`.

A subarray is a contiguous  **non-empty**  sequence of elements within an array.

 

 **Example 1:** 

```
Input: nums = [1,1,1], k = 2
Output: 2

```

 **Example 2:** 

```
Input: nums = [1,2,3], k = 3
Output: 2

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 104
- -1000 <= nums[i] <= 1000
- -107 <= k <= 107

## Solution

**Language:** Java  
**Runtime:** 24 ms (beats 75.96%)  
**Memory:** 48.4 MB (beats 93.03%)  
**Submitted:** 2026-10-16T17:49:34.183Z  

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/)