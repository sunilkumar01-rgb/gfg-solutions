# Maximum XOR of Two Numbers in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, return  *the maximum result of* `nums[i] XOR nums[j]`, where `0 <= i <= j < n`.

 

Original
Java
 **Example 1:** 

```
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

```

 **Example 2:** 

```
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127

```

 

 **Constraints:** 

- 1 <= nums.length <= 2 * 105
- 0 <= nums[i] <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 588 ms (beats 79.21%)  
**Memory:** 241.2 MB (beats 32.10%)  
**Submitted:** 2026-11-18T06:31:28.034Z  

```java
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0, mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = maxXor | (1 << i);
            
            for (int prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    maxXor = temp;
                    break;
                }
            }
        }
        return maxXor;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)