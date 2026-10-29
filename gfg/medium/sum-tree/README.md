# Sum Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the root of a Binary Tree with  **n**  nodes, check whether it is a Sum Tree and return true if it is, otherwise return false.

A Sum Tree is a Binary Tree in which the value of every non-leaf node is equal to the sum of all nodes present in its left and right subtrees. An empty tree and a leaf node are also considered Sum Trees.

 **Examples:** 

```
Input: root[] = [3, 1, 2]
 
Output: true
Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore, the given binary tree is a sum tree.
```

```
Input: root[] = [10, 20, 30, 10, 10]
 
Output: false
Explanation: The given tree is not a Sum Tree. For the root node, the sum of nodes in the left and right subtrees is 40 + 30 = 70, which is not equal to the root value 10.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T20:15:11.821Z  

```java
class Solution {
    boolean isSumTree(Node root) {
        return checkSumTree(root) != -1;
    }

    int checkSumTree(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;

        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);

        if (leftSum == -1 || rightSum == -1 || node.data != leftSum + rightSum) {
            return -1;
        }

        return node.data + leftSum + rightSum;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/sum-tree/1)