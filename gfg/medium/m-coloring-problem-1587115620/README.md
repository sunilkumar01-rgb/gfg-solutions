# M-Coloring Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an undirected graph consisting of  **V**  vertices and  **E**  edges represented by a list  **edges[][]**, along with an integer  **m**. Your task is to find if it is possible to color the graph using at most m different colors such that no two adjacent vertices share the same color. 

 **Note:**  The graph is indexed with 0-based indexing.

 **Examples:** 

```
Input: V = 4, edges[][] = [[0, 1], [1, 3], [2, 3], [3, 0], [0, 2]], m = 3
Output: true
Explanation: It is possible to color the given graph using 3 colors, for example, one of the possible ways vertices can be colored as follows:

Vertex 0: Color 1
Vertex 1: Color 2
Vertex 2: Color 2
Vertex 3: Color 3

```

```
Input: V = 3, edges[][] = [[0, 1], [1, 2], [0, 2]], m = 2
Output: false
Explanation: It is not possible to color the given graph using only 2 colors because vertices 0, 1, and 2 form a triangle.
```

 **Constraints:** 
1 ≤ V ≤ 10
1 ≤ E = edges.size() ≤ (V*(V-1))/2
0 ≤ edges[i][j] ≤ V-1
1 ≤ m ≤ V

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-01T15:22:09.143Z  

```java
class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {

        boolean[][] graph = new boolean[v][v];

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }

        int[] color = new int[v];

        return solve(0, v, m, graph, color);
    }

    boolean solve(int node, int v, int m,
                  boolean[][] graph, int[] color) {

        if (node == v) {
            return true;
        }

        for (int c = 1; c <= m; c++) {

            boolean safe = true;

            for (int i = 0; i < v; i++) {
                if (graph[node][i] && color[i] == c) {
                    safe = false;
                    break;
                }
            }

            if (safe) {
                color[node] = c;

                if (solve(node + 1, v, m, graph, color)) {
                    return true;
                }

                color[node] = 0;
            }
        }

        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1)