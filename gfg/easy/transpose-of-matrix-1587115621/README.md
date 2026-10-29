# Transpose of Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a square matrix of size  **n x n**, return the transpose matrix of the given matrix.

The transpose of a matrix is obtained by converting all the rows to columns and all the columns to rows.

 **Examples:** 

```
Input : mat[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output : [[1, 4, 7], [2, 5, 8], [3, 6, 9]]
Explanation: The first row [1, 2, 3] becomes the first column, the second row [4, 5, 6] becomes the second column, and the third row [7, 8, 9] becomes the third column.

```

```
Input : mat[][] =  [[1, 2], [1, 2]]
Output : [[1, 1], [2, 2]]
Explanation: The first column contains the first elements of both rows, [1, 1], and the second column contains the second elements, [2, 2].

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T20:16:55.077Z  

```java
class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int rows = mat.length;
        int cols = mat[0].length;

        for (int j = 0; j < cols; j++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                row.add(mat[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/transpose-of-matrix-1587115621/1)