# Linked List Group Reverse

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a Singly linked list, reverse every  **k**  node in the linked list and return the head of the modified list. If the node count is not a multiple of k then the left-out nodes at the end, should be considered as a group and must be reversed.

 **Examples:** 

```
Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2

Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 2.

```

```
Input: head: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 4,

Output: 4 -> 3 -> 2 -> 1 -> 6 -> 5
Explanation: Linked List is reversed in a group of size k = 4.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-25T17:19:46.858Z  

```java
class Solution {
    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        int count = 0;

        // Check karo ki k nodes available hain ya nahi
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // Agar humne k nodes dhundh liye, toh reverse karo
        // Agar k se kam hain (last group), toh count == k nahi hoga, par fir bhi question ke hisaab se reverse karna hai
        curr = head;
        Node prev = null;
        Node next = null;
        int i = 0;

        // Group ke andar ke nodes ko reverse karo
        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Agar aage aur nodes bache hain, toh recursively unhe reverse karo aur jod do
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // prev ab naye group ka head hai
        return prev;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1)