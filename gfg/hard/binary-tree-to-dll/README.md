# Binary Tree  to DLL

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given the  **root** of a binary tree, convert it to a Doubly Linked List (DLL) in place, using the same node structure.

- The left and right pointers in the binary tree nodes should be used as prev and next pointers respectively in the resulting DLL.
- The DLL should be formed by performing an inorder traversal of the binary tree (i.e., Left -> Root -> Right).
- The first node in the inorder traversal (i.e., the leftmost node) should become the head of the DLL.

Return the head of the resulting DLL.

 **Examples:** 

```
Input: root = [1, 2, 3]
Output: 
2 1 3
3 1 2
Explanation: Inorder traversal visits 2, 1, 3. Node 2 becomes the head of the DLL, giving the list 2 <=> 1 <=> 3.

```

```
Input: root = [10, 20, 30, 40, 60]
Output: 
40 20 60 10 30 
30 10 60 20 40 
Explanation: Inorder traversal visits 40, 20, 60, 10, 30. Node 40 becomes the head of the DLL, giving the list 40 <=> 20 <=> 60 <=> 10 <=> 30.

```

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T17:18:57.757Z  

```cpp
class Solution {
  public:
    Node* prev = nullptr;
    Node* head = nullptr;

    void inorder(Node* root) {
        if (root == nullptr) return;

        inorder(root->left);

        if (prev == nullptr) {
            head = root;
        } else {
            prev->right = root;
            root->left = prev;
        }

        prev = root;

        inorder(root->right);
    }

    Node* treeToDLL(Node* root) {
        prev = nullptr;
        head = nullptr;

        inorder(root);

        if (head != nullptr)
            head->left = nullptr;

        if (prev != nullptr)
            prev->right = nullptr;

        return head;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1)