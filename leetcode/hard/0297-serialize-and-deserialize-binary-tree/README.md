# Serialize and Deserialize Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 **Clarification:**  The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

 

 **Example 1:** 

```
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

```

 **Example 2:** 

```
Input: root = []
Output: []

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 104].
- -1000 <= Node.val <= 1000

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 47.34%)  
**Memory:** 47 MB (beats 98.77%)  
**Submitted:** 2026-10-23T17:58:55.701Z  

```java
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        for (int i = 1; i < arr.length; i++) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            if (!arr[++i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
        }
        return root;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)