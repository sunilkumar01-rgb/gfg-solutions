# Detect Loop in Linked List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a singly linked list, find if the given linked list contains a **loop or not**. A loop exists in a linked list if the next pointer of the last node points to any other node in the list (including itself), rather than being null.

 **Note:** Internally, pos(1 based index) is used to denote the position of the node that tail's next pointer is connected to. If pos = 0, it means the last node points to null. Note that pos is not passed as a parameter.

 **Examples:** 

```
Input: pos = 2,
   
Output: true
Explanation: There exists a loop as last node is connected back to the second node.

```

```
Input: pos = 0,
   
Output: false
Explanation: There exists no loop in given linked list.

```

```
Input: pos = 1,
   
Output: true
Explanation: There exists a loop as last node is connected back to the first node.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T17:30:39.862Z  

```java
class Solution {
    public boolean detectLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1)