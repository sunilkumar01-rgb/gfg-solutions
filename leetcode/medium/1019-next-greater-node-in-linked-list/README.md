# Next Greater Node In Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the `head` of a linked list with `n` nodes.

For each node in the list, find the value of the  **next greater node**. That is, for each node, find the value of the first node that is next to it and has a  **strictly larger**  value than it.

Return an integer array `answer` where `answer[i]` is the value of the next greater node of the `ith` node (**1-indexed**). If the `ith` node does not have a next greater node, set `answer[i] = 0`.

 

 **Example 1:** 

```
Input: head = [2,1,5]
Output: [5,5,0]

```

 **Example 2:** 

```
Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]

```

 

 **Constraints:** 

- The number of nodes in the list is n.
- 1 <= n <= 104
- 1 <= Node.val <= 109

## Solution

**Language:** Java  
**Runtime:** 23 ms (beats 57.44%)  
**Memory:** 49.5 MB (beats 70.24%)  
**Submitted:** 2026-10-11T17:32:55.980Z  

```java
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int[] ans = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                ans[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        
        return ans;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/next-greater-node-in-linked-list/)