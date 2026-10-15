# Remove Cycle in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **head** of a singly linked list. A cycle exists if the last node points back to a previous node, forming a loop. Remove the loop from the linked list if it exists.

Internally, the driver code uses a variable  **x**  (1-based indexing) to represent the position of the node to which the last node is connected.

The driver code will print "true" if the linked list is correctly modified, otherwise it will print "false".

 **Examples:** 

```
Input:

Output: true
Explanation: The linked list contains a loop that begins at node x = 2. After removing the loop, the driver code prints true.
```

```
Input:

Output: true
Explanation: The linked list does not contain a loop (x = 0).
```

```
Input: 

Output: true
Explanation: The linked list contains a loop that begins at node x = 1. After removing the loop, the driver code prints true.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T17:16:15.067Z  

```java
class Solution {
    public void removeLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow == fast) {
            slow = head;
            if (slow == fast) {
                while (fast.next != slow) fast = fast.next;
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            fast.next = null;
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1)