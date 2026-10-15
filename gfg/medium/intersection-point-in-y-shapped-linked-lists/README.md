# Intersection in Y Shaped Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the heads of two non-empty singly linked lists,  **head1**  and  **head2**, return the node where the two linked lists intersect. If the two lists do not intersect, return null.

 **Note:**  The custom input contains a non-empty singly linked list common. Initially, head1 and head2 do not share any node. The last node of each list is then connected to the head of common, creating an intersection at the first node of common. If common is empty, the two lists do not intersect at all.

 **Examples:** 

```
Input: head1: 10 -> 15 -> 30, head2: 3 -> 6 -> 9 -> 15 -> 30
Output: 15
Explanation: From the image, it is clear that the common part is 15 -> 30, and its starting node is 15.

```

```
Input: head1: 4 -> 1 -> 8 -> 5, head2: 5 -> 6 -> 1 -> 8 -> 5
Output: 1
Explanation: From the image, it is clear that the common part is 1 -> 8 -> 5, and its starting node is 1.

```

**Constraints:
**2 ≤ total number of nodes ≤ 2*105
-104 ≤ node->data ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T17:17:48.306Z  

```java
class Solution {
    Node intersectPoint(Node head1, Node head2) {
        Node a = head1, b = head2;

        while (a != b) {
            a = (a == null) ? head2 : a.next;
            b = (b == null) ? head1 : b.next;
        }

        return a;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1)