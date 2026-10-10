# Summed Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given two integers  **n** and  **q**, consider a n * n matrix where the value at cell (i, j) is i + j, with both row and column indices starting from 1. Return the number of cells whose value is equal to q.

 **Note:**  The matrix uses 1-based indexing.

 **Examples:** 

```
Input: n = 4, q = 7
Output: 2
Explanation: Matrix becomes
2 3 4 5 
3 4 5 6 
4 5 6 7
5 6 7 8
The count of 7 is 2.
```

```
Input: n = 5, q = 4
Output: 3
Explanation: Matrix becomes
2 3 4 5 6 
3 4 5 6 7 
4 5 6 7 8 
5 6 7 8 9 
6 7 8 9 10 
The count of 4 is 3.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-10T10:33:36.594Z  

```java
class Solution {
    public int sumMatrix(int n, int q) {
        // code here
        int low=Math.max(1,q-n);
        int high=Math.min(n, q-1);
        
        int ans=Math.max(0,high-low+1);
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/summed-matrix5834/1)