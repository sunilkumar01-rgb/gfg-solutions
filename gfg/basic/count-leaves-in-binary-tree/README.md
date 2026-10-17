# Count Leaves in Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Basic-red)

## Problem

Given a Binary Tree, you need to count leaves in it. 

 **Examples:** 

```
Input: root[] = [4, 8, 10, 7, 5, 1, 3]

Output: 3
Explanation: Three leaves are 3, 5 and 1.

```

```
Input: root[] = [50, 30, 70, 20, 40, 60, 80, 65]

Output: 4
Explanation: Four leaves are 20, 40, 65 and 80.

```

```
Input: root[] = [30, 25, 35, 20, 28, 40, 27] 

Output: 3
Explanation: Three leaves are 20, 27 and 40.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-17T18:04:04.235Z  

```java
class Solution {
    int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1)