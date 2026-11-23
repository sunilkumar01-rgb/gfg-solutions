# Matrix Snake Pattern

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a matrix **mat[][]** of size **n x n**. Print the elements of the matrix in the snake like pattern depicted below.

 **Examples :** 

```
Input: n = 3, mat[][] = [[45, 48, 54], [21, 89, 87], [70, 78, 15]]
Output: [45, 48, 54, 87, 89, 21, 70, 78, 15] 
Explanation: Printing it in snake pattern will lead to the output as [45, 48, 54, 87, 89, 21, 70, 78, 15.
```

```
Input: n = 2, mat[][] = [[1, 2], [3, 4]]
Output: [1, 2, 4, 3] 
Explanation: Printing it in snake pattern will give output as [1, 2, 4, 3].
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-23T18:05:04.397Z  

```java
class Solution {
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Even row: Left to Right
                for (int j = 0; j < n; j++) {
                    ans.add(matrix[i][j]);
                }
            } else {
                // Odd row: Right to Left
                for (int j = n - 1; j >= 0; j--) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/print-matrix-in-snake-pattern-1587115621/1)