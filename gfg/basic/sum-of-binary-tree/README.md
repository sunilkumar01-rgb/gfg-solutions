# Sum of Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a binary tree, find the sum of values of all the nodes. 

 **Examples:** 

```
Input: root = [15, 10, 20, 8, 12, 16, 25]

Output: 106
Explanation: The sum of all the nodes is 15 + 10 + 20 + 8 + 12 + 16 + 25 = 106
.
```

```
Input: root = [1, 3, 2]

Output: 6
Explanation: The sum of all the nodes is 1 + 2 + 3 = 6.
```

```
Input: root = [1, 2, N, 4, N]

Output: 7
Explanation: The sum of all the nodes is 1 + 2 + 4 = 7.
```

 **Constraints:** 
1 ≤ number of nodes ≤ 104
-105 ≤ Node data ≤ 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T18:04:39.820Z  

```java
class Solution {
    static int sumBT(Node head) {
        if (head == null) return 0;
        return head.data + sumBT(head.left) + sumBT(head.right);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-of-binary-tree/1)