# Directed Graph Cycle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a directed graph with  **V**  vertices, numbered from 0 to V - 1, represented by an adjacency list  **adj[][]**, where adj[u] contains all vertices reachable from vertex u through a directed edge, check whether the graph contains a cycle.

 **Note:** The graph may have multiple connected components. Self-loops are allowed, but repeated edges are not allowed.

 **Examples:** 

```
Input: adj[][] = [[1], [2], [0, 3], []]

Output: true
Explanation: The diagram clearly shows a cycle 0 -> 1 -> 2 -> 0
```

```
Input: adj[][] = [[1, 2], [2], [3], []]

Output: false
Explanation: The graph does not contain any cycle.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-21T17:17:39.028Z  

```java
import java.util.*;

class Solution {
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) return true;
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }

        pathVisited[node] = false;
        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1)