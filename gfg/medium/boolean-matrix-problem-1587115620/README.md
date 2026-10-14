# Boolean Matrix

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a boolean matrix  **mat[],**  where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in its ith row and jth column will become 1.

 **Examples:** 

```
Input: mat[][] = [[1, 0], [0, 0]]
Output: [[1, 1], [1, 0]] 
Explanation: Only cell that has 1 is at (0,0) so all cells in row 0 are modified to 1 and all cells in column 0 are modified to 1.
```

```
Input: mat[][] = [[1, 0, 0], [1, 0, 0], [1, 0, 0], [0, 0, 0]]
Output: [[1, 1, 1], [1, 1, 1], [1, 1, 1], [1, 0, 0]]
Explanation: The position of cells that have 1 in the original matrix are (0, 0), (1, 0) and (2, 0). Therefore, all cells in row 0, 1, 2 are and column 0 are modified to 1. 
```

```
Input: mat[][] = [[0, 0], [0, 0]]
Output: [[0, 0], [0, 0]] 
Explanation: There is no cell that contains 1, so mat[] will remain the same.
```

 **Constraints:** 
1 ≤ mat.size(), mat[0].size() ≤ 103
0 ≤ mat[i][j] ≤ 1

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-14T08:38:58.335Z  

```java
class Solution {
    void booleanMatrix(int mat[][]) {
       // code here
        int m = mat.length;
                int n = mat[0].length;

                boolean[] row = new boolean[m];
                boolean[] col = new boolean[n];

                //Find  ones
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {

                        if (mat[i][j] == 1) {
                            row[i] = true;
                            col[j] = true;
                        }
                    }
                }

                //  required elements to one
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {

                        if (row[i] || col[j]) {
                            mat[i][j] = 1;
                        }
                    }
                }


    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1)