# Minimum Cost Path with 4 Moves

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a square matrix  **grid[][]**, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.  From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

 **Examples :** 

```
Input: grid[][] = [[9, 4, 9, 9], [6, 7, 6, 4], [8, 3, 3, 7], [7, 4, 9, 10]]
Output: 43
Explanation: The minimum cost is 9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.

```

```
Input: grid[][] = [[4, 4], [3, 7]]
Output: 14
Explanation: The minimum cost is- 4 + 3 + 7 = 14.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-20T17:40:40.090Z  

```java
import java.util.*;

class Solution {
    public static int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Min-Heap based on cost {cost, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dist = new int[n][m];

        // Initialize distances with infinity
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If we reached the bottom-right cell
            if (r == n - 1 && c == m - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newCost = cost + grid[nr][nc];

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{newCost, nr, nc});
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1)