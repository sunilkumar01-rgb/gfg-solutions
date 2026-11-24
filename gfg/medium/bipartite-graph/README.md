# Bipartite Graph

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an undirected graph represented by an adjacency list **adj[][]**, check whether the graph is bipartite or not.

A bipartite graph is a graph whose vertices can be colored using two colors such that no two adjacent vertices have the same color. Equivalently, the vertices can be divided into two disjoint sets such that:

- Every edge connects a vertex from one set to a vertex in the other set.
- No edge connects two vertices within the same set.

 **Examples:** 

```
Input: adj[][] = [[1], [0, 2], [1]]

Output: true
Explanation: The vertices can be colored using two colors such that every pair of adjacent vertices has different colors.
```

```
Input: adj[][] = [[3, 2], [2], [0, 1, 3], [0, 2]]

Output: false 
Explanation: The vertices form a triangle, so it is not possible to color them using two colors without two adjacent vertices having the same color.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-24T16:52:12.860Z  

```java
import java.util.*;

class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int neighbor : adj.get(node)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bipartite-graph/1)