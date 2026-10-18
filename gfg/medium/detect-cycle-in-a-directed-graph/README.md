# Directed Graph Cycle

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a directed graph with  **V**  vertices numbered from 0 to V - 1 and E directed edges. The graph is represented using a 2D array  **edges[][]**  of size E, where each entry edges[i] = [u, v] denotes a directed edge from vertex u to vertex v.

Check whether the graph contains any cycle. Return true if there exists at least one cycle in the graph; otherwise, return false.

 **Examples:** 

```
Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]

Output: true
Explanation: The diagram clearly shows a cycle 0 -> 1 -> 2 -> 0
```

```
Input: V = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]

Output: false
Explanation: no cycle in the graph
```

 **Constraints:** 
1 ≤ V ≤ 105
0 ≤ E ≤ 105
0 ≤ edges[i][0], edges[i][1] < V

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-18T04:41:44.837Z  

```java
class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, pathVisited)) {
                    return true;
                }
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