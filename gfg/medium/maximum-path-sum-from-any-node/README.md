# Maximum Path Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the  **root**  of a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

 **Examples:** 

```
Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: Max path sum is represented using green colored nodes in the above binary tree.

```

```
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: Max path sum is represented using green colored nodes in the above binary tree.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-27T17:56:24.956Z  

```java
class Solution {
    int maxSum = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    private int solve(Node node) {
        if (node == null) return 0;

        // Left aur Right subtree se maximum sum nikaalo
        // Agar negative aa raha hai, toh 0 lo (matlab us path ko ignore karo)
        int left = Math.max(0, solve(node.left));
        int right = Math.max(0, solve(node.right));

        // Current node ko root maan kar path ka sum
        int currentPathSum = node.data + left + right;

        // Global maxSum update karo
        maxSum = Math.max(maxSum, currentPathSum);

        // Parent ko batao ki is node se guzarne wala best path kya hai
        // Parent ko sirf ek hi side (left ya right) choose karni hoti hai
        return node.data + Math.max(left, right);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1)