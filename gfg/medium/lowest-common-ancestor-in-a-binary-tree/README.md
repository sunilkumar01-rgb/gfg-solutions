# LCA in  Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **root**  of a binary tree with all unique values and two nodes value,  **n1**  and  **n2**.

Find the lowest common ancestor of the given two nodes. Both node values are always present in the Binary Tree.

 **Note:**  LCA is the first common ancestor of both the nodes n1 and n2 from bottom of tree.

 **Examples:** 

```
Input: root = [1, 2, 3, 4, 5, 6, 7], n1 = 4, n2 = 5    

Output: 2
Explanation: LCA of 4 and 5 is 2.

```

```
Input: root = [1, 2, 3, N, N, 6, 7, 8], n1 = 7, n2 = 8  

Output: 3
Explanation: LCA of 7 and 8 is 3.
 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T17:28:45.406Z  

```java
class Solution {
    Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1)