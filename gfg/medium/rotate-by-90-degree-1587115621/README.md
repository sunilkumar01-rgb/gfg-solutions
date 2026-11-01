# Rotate by 90 degree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a square matrix  **mat[][]**. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

 **Examples:** 

```
Input: mat[][] = [[0, 1, 2], [3, 4, 5], [6, 7, 8]] 
Output: [[2, 5, 8], [1, 4, 7], [0, 3, 6]]
```

```
Input: mat[][] = [[1, 2], [3, 4]]
Output: [[2, 4], [1, 3]]

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:08:42.866Z  

```java
class Solution {
    public void rotateMatrix(int[][] mat) {

        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse every column
        for (int j = 0; j < n; j++) {

            int top = 0;
            int bottom = n - 1;

            while (top < bottom) {

                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;

                top++;
                bottom--;
            }
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1)