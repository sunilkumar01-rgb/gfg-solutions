# Binary Tree Maximum Path Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

A  **path**  in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence  **at most once**. Note that the path does not need to pass through the root.

The  **path sum**  of a path is the sum of the node's values in the path.

Given the `root` of a binary tree, return  *the maximum  **path sum**  of any  **non-empty**  path*.

 

 **Example 1:** 

```
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

```

 **Example 2:** 

```
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 3 * 104].
- -1000 <= Node.val <= 1000

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 49.22%)  
**Memory:** 46.1 MB (beats 94.44%)  
**Submitted:** 2026-11-03T19:01:12.962Z  

```java
class Solution {
    int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    
    private int maxGain(TreeNode node) {
        if (node == null) return 0;
        
        // Sirf positive gains consider karo
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        
        // Current node ko root maan kar path ka sum
        int priceNewpath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewpath);
        
        // Parent ko return karo max gain (ya toh left ya right)
        return node.val + Math.max(leftGain, rightGain);
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-maximum-path-sum/)