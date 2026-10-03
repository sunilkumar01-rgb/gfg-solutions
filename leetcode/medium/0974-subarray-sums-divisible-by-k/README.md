# Subarray Sums Divisible by K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the number of non-empty  **subarrays**  that have a sum divisible by* `k`.

A  **subarray**  is a  **contiguous**  part of an array.

 

 **Example 1:** 

```
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

```

 **Example 2:** 

```
Input: nums = [5], k = 9
Output: 0

```

 

 **Constraints:** 

- 1 <= nums.length <= 3 * 104
- -104 <= nums[i] <= 104
- 2 <= k <= 104

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 78.16%)  
**Memory:** 54.8 MB (beats 6.44%)  
**Submitted:** 2026-10-03T07:38:08.429Z  

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);
        
        int prefixSum = 0;
        int ans = 0;
        
        for (int num : nums) {
            prefixSum = ((prefixSum + num) % k + k) % k;
            ans += remainderCount.getOrDefault(prefixSum, 0);
            remainderCount.put(prefixSum, remainderCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sums-divisible-by-k/)