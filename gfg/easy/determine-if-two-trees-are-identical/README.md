# Identical Trees

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two binary trees with their root nodes  **r1**  and  **r2**, return true if both of them are  **identical**, otherwise return false.
 **Note:** Two trees are identical when they have the same data and the arrangement of the data is also same.

 **Examples:** 

```
Input: r1 = [1, 2, 3, 4], r2 = [1, 2, 3, 4]

Output: true
Explanation: Trees are identical.
```

```
Input: r1 = [1, 2, 3, 4], r2 = [1, 2, 3, N, N, 4]
 
Output: false
Explanation: Trees are not identical.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-16T17:55:57.767Z  

```java
class Solution {
    boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data != root2.data) return false;

        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1)