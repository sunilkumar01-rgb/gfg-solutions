# Intersection of Two Arrays

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integer arrays `nums1` and `nums2`, return  *an array of their intersection*. Each element in the result must be  **unique**  and you may return the result in  **any order**.

 

 **Example 1:** 

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

```

 **Example 2:** 

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

```

 

 **Constraints:** 

- 1 <= nums1.length, nums2.length <= 1000
- 0 <= nums1[i], nums2[i] <= 1000

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 97.95%)  
**Memory:** 44.5 MB (beats 92.46%)  
**Submitted:** 2026-10-15T16:56:33.388Z  

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        
        HashSet<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) result.add(num);
        }
        
        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) ans[i++] = num;
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/intersection-of-two-arrays/)