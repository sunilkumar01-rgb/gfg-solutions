# Merge Two Sorted Linked Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **head**  of two sorted linked lists consisting of nodes respectively. Merge both lists and return the head of the sorted merged list.

 **Examples:** 

```
Input:
  
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
Explanation:
   
```

```
Input:
  
Output: 1 -> 1 -> 2 -> 4
Explanation:
  
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T17:26:30.992Z  

```java
class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node curr = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        curr.next = (head1 != null) ? head1 : head2;
        return dummy.next;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1)