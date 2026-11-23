# Union of Two Linked Lists

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two singly linked lists, create a new linked list that contains the union of elements present in both lists. Each element should appear only once in the resulting list (no duplicates allowed).
The order of elements in the resulting list should be:

- First, include elements from the first list in the order they appear.
- Then include elements from the second list that were not already included, in their original order.

 **Examples:** 

```
Input: head1 = [9, 6, 4, 2, 3, 8], head2 = [1, 2, 8, 6, 2]

Output: 9 -> 6 -> 4 -> 3 -> 8 -> 1 -> 2

Explanation: All the distinct numbers from two lists. 
```

```
Input: head1 = [1, 5, 1, 2, 2, 5], head2 = [4, 5, 6, 7, 1]
 
Output: 1 -> 5 -> 2 -> 4 -> 6 -> 7

Explanation: All the distinct numbers from two lists.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-23T18:01:30.359Z  

```java
import java.util.*;

class Solution {
    public Node makeUnion(Node head1, Node head2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // Pehli list ke elements add karo
        Node curr = head1;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Dusri list ke elements add karo (jo pehle se nahi hain)
        curr = head2;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Nayi Linked List banao
        if (set.isEmpty()) return null;

        Node dummy = new Node(0);
        Node temp = dummy;

        for (int val : set) {
            temp.next = new Node(val);
            temp = temp.next;
        }

        return dummy.next;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/union-of-two-linked-list/1)