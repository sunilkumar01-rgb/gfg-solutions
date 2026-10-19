# Top K Frequent Elements

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums` and an integer `k`, return  *the*  `k`  *most frequent elements*. You may return the answer in  **any order**.

 

 **Example 1:** 

 **Input:**  nums = [1,1,1,2,2,3], k = 2

 **Output:**  [1,2]

 **Example 2:** 

 **Input:**  nums = [1], k = 1

 **Output:**  [1]

 **Example 3:** 

 **Input:**  nums = [1,2,1,2,1,2,3,1,3,2], k = 2

 **Output:**  [1,2]

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -104 <= nums[i] <= 104
- k is in the range [1, the number of unique elements in the array].
- It is guaranteed that the answer is unique.

 

 **Follow up:**  Your algorithm's time complexity must be better than `O(n log n)`, where n is the array's size.

## Solution

**Language:** Java  
**Runtime:** 16 ms (beats 41.40%)  
**Memory:** 47.2 MB (beats 95.32%)  
**Submitted:** 2026-10-19T12:48:48.167Z  

```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int num : count.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/top-k-frequent-elements/)