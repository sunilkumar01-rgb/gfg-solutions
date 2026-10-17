# BST Insert

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a  **root**  of Binary Search Tree (BST) and an integer  **key**, insert a new node with value key into the BST. Return the root of the modified tree after the insertion.

 **Note:** If the key is already present in the BST, return the root.

 **Examples :** 

```
Input: root = [2, 1, 3], key = 4

Output: [2, 1, 3, N, N, N, 4]
Explanation: After inserting the node 4, the new tree will be [2, 1, 3, N, N, N, 4].

```

```
Input: root = [2, 1, 3, N, N, N, 6], key = 4

Output: [2, 1, 3, N, N, N, 6, 4]
Explanation: After inserting the node 4, the new tree will be [2, 1, 3, N, N, N, 6, 4].

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T18:07:43.736Z  

```java
class Solution {
    Node insert(Node root, int Key) {
        if (root == null) {
            return new Node(Key);
        }

        if (Key < root.data) {
            root.left = insert(root.left, Key);
        } else if (Key > root.data) {
            root.right = insert(root.right, Key);
        }

        return root;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1)