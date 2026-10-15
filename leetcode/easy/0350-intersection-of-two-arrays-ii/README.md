# Intersection of Two Arrays II

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integer arrays `nums1` and `nums2`, return  *an array of their intersection*. Each element in the result must appear as many times as it shows in both arrays and you may return the result in  **any order**.

 

 **Example 1:** 

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

```

 **Example 2:** 

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

```

 

 **Constraints:** 

- 1 <= nums1.length, nums2.length <= 1000
- 0 <= nums1[i], nums2[i] <= 1000

 

 **Follow up:** 

- What if the given array is already sorted? How would you optimize your algorithm?
- What if nums1's size is small compared to nums2's size? Which algorithm is better?
- What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 45.25%)  
**Memory:** 44.5 MB (beats 93.56%)  
**Submitted:** 2026-10-15T16:57:46.663Z  

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/intersection-of-two-arrays-ii/)