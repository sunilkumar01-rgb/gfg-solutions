# Process Zeros and Neighbors in Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a matrix  **mat[][]**, Your task is to do the following operations for every 0.

- Replace the zero with the sum of upper, lower, left and right values
- Make its four adjacent (upper, lower, left, and right) values zero.

 **Examples:** 

```
Input: mat[][] = [[1, 2, 3, 4], [5, 6, 0, 7], [8, 9, 4, 6], [8, 4, 5, 2]]
Output: mat[][] = [[1, 2, 0, 4], [5, 0, 20, 0], [8, 9, 0, 6], [8, 4, 5, 2]]
Explanation: As mat[1][2] = 0, we will perform the operation here. Then mat[1][2] = mat[0][2] + mat[2][2] + mat[1][1]  + mat[1][3] and mat[0][2] = matrix[2][2] = matrix[1][1] = matrix[1][3] = 0.

```

```
Input: mat[][] = [[1, 2], [3, 4]]
output: mat[][] = [[1, 2], [3, 4]]
Explanation: As there is no zero in the matrix, no operation is performed and the matrix remains unchanged.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-16T09:01:53.142Z  

```java
class Solution {
	void makeZeros(int[][] mat) {
		// code here
		int row = mat.length;
		int col = mat[0].length;
		int [][] ans = new int[row][col];
		
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				ans[i][j] = mat[i][j];
			}
		}
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				
				if (mat[i][j] == 0) {
					int sum = 0;
					if (i - 1 >= 0) {
						sum += mat[i - 1][j];
						ans[i - 1][j] = 0;
					}
					if (i + 1<row) {
						sum += mat[i + 1][j];
						ans[i + 1][j] = 0;
					}
					if (j - 1 >= 0) {
						sum += mat[i][j - 1];
						ans[i][j - 1] = 0;
					}
					if (j + 1<col) {
						sum += mat[i][j + 1];
						ans[i][j + 1] = 0;
					}
					ans[i][j] = sum;
				}
			}
		}
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				mat[i][j] = ans[i][j];
			}
		}
	}
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/make-zeroes4042/1)