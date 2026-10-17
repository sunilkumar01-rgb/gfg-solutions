# Children Sum in a Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary tree, find if it satisfies the Children Sum Property which has the following rules

- Each non-leaf node must have a value equal to the sum of its left and right children's values.
- A NULL child is considered to have a value of 0, and all leaf nodes are considered valid by default.

 **Examples:** 

```
Input: root = [35, 20, 15, 15, 5, 10, 5]

Output: True
Explanation: Here, every node is sum of its left and right child.
```

```
Input: root = [1, 4, 3, 5]
  
Output: False
Explanation: Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given condition.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T18:05:34.411Z  

```java
class Solution {
    public static boolean isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        if (root.data == sum && 
            isSumProperty(root.left) && 
            isSumProperty(root.right)) {
            return true;
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/children-sum-parent/1)