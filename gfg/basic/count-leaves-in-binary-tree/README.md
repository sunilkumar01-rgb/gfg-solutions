# Count Leaves in Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a Binary Tree of size  **n**, You have to count leaves in it. For example, there are two leaves in the following tree

 

 **Examples:** 

```
Input:
Given Tree is  

Output: 3
Explanation: Three leaves are 3, 5 and 1.

```

```
Input:
Given Tree is

Output: 4
Explanation: Four leaves are 20, 40, 65 and 80.

```

```
Input:
Given Tree is  

Output: 3
Explanation: Three leaves are 20, 27 and 40.
```

  **Constraints:** 
1<= number of nodes <= 105
1<= node->data <= 105

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-16T17:56:43.635Z  

```java
class Solution {
    int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1)