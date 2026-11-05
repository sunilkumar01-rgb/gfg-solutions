# Shortest Subarray with Sum at Least K

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and an integer `k`, return  *the length of the shortest non-empty  **subarray**  of* `nums` *with a sum of at least* `k`. If there is no such  **subarray**, return `-1`.

A  **subarray**  is a  **contiguous**  part of an array.

 

 **Example 1:** 

```
Input: nums = [1], k = 1
Output: 1

```

 **Example 2:** 

```
Input: nums = [1,2], k = 4
Output: -1

```

 **Example 3:** 

```
Input: nums = [2,-1,2], k = 3
Output: 3

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- -105 <= nums[i] <= 105
- 1 <= k <= 109

## Solution

**Language:** Java  
**Runtime:** 20 ms (beats 86.74%)  
**Memory:** 66.1 MB (beats 58.06%)  
**Submitted:** 2026-11-05T16:32:13.538Z  

```java
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        int minLen = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)