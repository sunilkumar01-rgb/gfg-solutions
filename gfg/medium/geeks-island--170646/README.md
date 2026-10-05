# Towers Reaching Both Stations

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a matrix  **mat[][]**  of size  **n x m**, where mat[i][j] represents the signal strength of a communication tower. Two control stations monitor the network:

- Station P covers the top and left boundaries of the grid.
- Station Q covers the bottom and right boundaries of the grid.

A signal can propagate from a tower to one of its neighbouring towers in the four directions (North, South, East, and West) only if the neighbouring tower has a signal strength less than or equal to that of the current tower.

Determine the  **number of towers (x, y)**  from which a signal can eventually reach both Station P and Station Q. Any tower located on a boundary covered by a station can transmit directly to that station.

 **Examples:** 

```
Input: mat[][] = [[1, 2, 2, 3, 5], [3, 2, 3, 4, 4], [2, 4, 5, 3, 1], [6, 7, 1, 4, 5], [5, 1, 1, 2, 4]]
Output: 7
Explanation: 

(0, 4) & (4, 0) are part of both P & Q 
(1, 3) reaches P using (1,3)->(0,3) and Q using (1,3)->(1,4)
(1, 4) reaches P using (1,4)->(1,3)->(1,2)->(0,2) and it is on Q
(2, 2) reaches P using (2,2)->(2,1)->(2,0) and Q using (2,2)->(2,3)->(2,4)
(3, 0) is on P and reaches Q using (3,0)->(4,0)
(3, 1) reaches P using (3,1)->(3,0) and Q using (3,1)->(4,1)
```

```
Input: mat[][] = [[2, 2], [2, 2]]
Output: 4
Explanation: In the following example, all cells allow signals to propagate to both the stations.
```

 **Constraints:** 
1 ≤ n, m ≤ 103
1 ≤ mat[i][j] ≤ 103

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T18:07:32.179Z  

```java
import java.util.*;

class Solution {
    private int n, m;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int countCoordinates(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            dfs(mat, 0, j, p);
        }
        for (int i = 0; i < n; i++) {
            dfs(mat, i, 0, p);
        }

        for (int j = 0; j < m; j++) {
            dfs(mat, n - 1, j, q);
        }
        for (int i = 0; i < n; i++) {
            dfs(mat, i, m - 1, q);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] mat, int r, int c, boolean[][] vis) {
        if (vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && mat[nr][nc] >= mat[r][c]) {
                dfs(mat, nr, nc, vis);
            }
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/geeks-island--170646/1)