# Fixing Two Nodes of BST

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given the  **root**  of a Binary Search Tree (BST), where exactly two nodes have been swapped by mistake, restore the BST by swapping the values of the misplaced nodes. Return the root of the corrected BST.
 
 **Note:**  It is guaranteed that exactly two nodes have been swapped, and restoring their values will make the tree a valid BST. The structure of the tree must remain unchanged.
 
 **Examples :** 

```
Input: root = [10, 5, 8, 2, 20]
     
Output: [10, 5, 20, 2, 8]
       

Explanation: The nodes 20 and 8 were swapped. 
```

```
Input: root = [5, 10, 20, 2, 8]
     
Output: [10, 5, 20, 2, 8]
     
Explanation: The nodes 10 and 5 were swapped.
```

 **Constraints:** 
2 ≤ Number of nodes ≤ 105
1 ≤ root[i] ≤ 107

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T17:22:52.825Z  

```cpp
class Solution {
  public:
    Node *first = nullptr, *middle = nullptr, *last = nullptr;
    Node *prev = nullptr;

    void inorder(Node* root) {
        if (root == nullptr) return;

        inorder(root->left);

        if (prev != nullptr && prev->data > root->data) {
            if (first == nullptr) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }

        prev = root;

        inorder(root->right);
    }

    Node* correctBST(Node* root) {
        first = middle = last = prev = nullptr;

        inorder(root);

        if (last != nullptr) {
            swap(first->data, last->data);
        } 
        else if (first != nullptr) {
            swap(first->data, middle->data);
        }

        return root;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1)