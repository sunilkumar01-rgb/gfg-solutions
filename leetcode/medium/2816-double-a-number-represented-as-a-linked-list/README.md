# Double a Number Represented as a Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given the `head` of a  **non-empty**  linked list representing a non-negative integer without leading zeroes.

Return  *the* `head` *of the linked list after  **doubling**  it*.

 

 **Example 1:** 

```
Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

```

 **Example 2:** 

```
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 

```

 

 **Constraints:** 

- The number of nodes in the list is in the range [1, 104]
- 0 <= Node.val <= 9
- The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 100.00%)  
**Memory:** 48.6 MB (beats 16.53%)  
**Submitted:** 2026-10-10T13:41:53.878Z  

```java
class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head.val >= 5) {
            head = new ListNode(0, head);
        }
        
        ListNode curr = head;
        while (curr != null) {
            curr.val = (curr.val * 2) % 10;
            if (curr.next != null && curr.next.val >= 5) {
                curr.val++;
            }
            curr = curr.next;
        }
        
        return head;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/)