# Binary Tree Paths

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You are given the `root` of a binary tree.

Return all  **root-to-leaf**  paths in  **any order**.

A  **leaf**  is a node with no children.

 

 **Example 1:** 

```
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

```

 **Example 2:** 

```
Input: root = [1]
Output: ["1"]

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 100].
- -100 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 72.95%)  
**Memory:** 43.9 MB (beats 89.72%)  
**Submitted:** 2026-10-17T17:55:12.671Z  

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) dfs(root, "", ans);
        return ans;
    }
    
    private void dfs(TreeNode node, String path, List<String> ans) {
        if (node.left == null && node.right == null) {
            ans.add(path + node.val);
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", ans);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", ans);
        }
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-paths/)