# Count Islands

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a grid of size  **n*m**  (n is the number of rows and m is the number of columns in the grid) consisting of  **'W'** s (Water) and  **'L'** s (Land). Find the number of islands.

 **Note:** An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

 **Examples:** 

```
Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], 
                ['W', 'L', 'W', 'W', 'L'], 
                ['L', 'W', 'W', 'L', 'L'], 
                ['W', 'W', 'W', 'W', 'W'], 
                ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
```

```
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
                ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Explanation:
The image below shows 2 islands in the grid.
 
```

 **Constraints:** 
1 ≤ n, m ≤ 500
grid[i][j] = {'L', 'W'}

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T17:23:19.544Z  

```java
class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'L') {
            return;
        }

        // Mark as visited (water) so we don't visit again
        grid[i][j] = 'W';

        // 8 directions (horizontal, vertical, diagonal)
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            dfs(grid, i + rowDir[k], j + colDir[k], n, m);
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1)