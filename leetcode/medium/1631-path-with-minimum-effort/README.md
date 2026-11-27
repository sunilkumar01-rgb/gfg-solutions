# Path With Minimum Effort

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are a hiker preparing for an upcoming hike. You are given `heights`, a 2D array of size `rows x columns`, where `heights[row][col]` represents the height of cell `(row, col)`. You are situated in the top-left cell, `(0, 0)`, and you hope to travel to the bottom-right cell, `(rows-1, columns-1)` (i.e.,  **0-indexed**). You can move  **up**,  **down**,  **left**, or  **right**, and you wish to find a route that requires the minimum  **effort**.

A route's  **effort**  is the  **maximum absolute difference**  in heights between two consecutive cells of the route.

Return  *the minimum  **effort**  required to travel from the top-left cell to the bottom-right cell.* 

 

Original
Java
 **Example 1:** 

```
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

```

 **Example 2:** 

```
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

```

 **Example 3:** 

```
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.

```

 

 **Constraints:** 

- rows == heights.length
- columns == heights[i].length
- 1 <= rows, columns <= 100
- 1 <= heights[i][j] <= 106

## Solution

**Language:** Java  
**Runtime:** 40 ms (beats 87.07%)  
**Memory:** 46.8 MB (beats 98.64%)  
**Submitted:** 2026-11-27T18:09:29.388Z  

```java
import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // {effort, row, col}
        
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0], r = curr[1], c = curr[2];
            
            if (r == m - 1 && c == n - 1) return effort;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i], nc = c + dy[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newEffort = Math.max(effort, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/path-with-minimum-effort/)