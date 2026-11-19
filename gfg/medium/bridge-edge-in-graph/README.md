# Bridge Edge in Graph

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an undirected graph with  **V**  vertices numbered from  **0** to **V-1**  and edges represented by 2d array  **edges[][]**, where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

 **Note:** 

- An edge is called a bridge if removing it increases the number of connected components of the graph.
- if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.

 **Examples :** 

```
Input: V = 4, edges[][] = [[0, 1], [1, 2], [2, 3]], c = 1, d = 2

Output: true
Explanation: From the graph, we can clearly see that blocking the edge 1-2 will result in disconnection of the graph.
Hence, it is a Bridge.

```

```
Input: V = 5, edges[][] = [[0, 1], [0, 3], [1, 2], [2, 0], [3, 4]], c = 0, d = 2
 
Output: false
Explanation:
 
Blocking the edge between nodes 0 and 2 won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge Edges in the graph are marked with a green line in the above image.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-19T16:02:14.185Z  

```java
class Solution {
    static int timer = 1;

    static boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        timer = 1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited, tin, low, c, d)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin, int[] low, int c, int d) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited, tin, low, c, d)) {
                    return true;
                }

                low[node] = Math.min(low[node], low[neighbor]);

                // Bridge condition: low[neighbor] > tin[node]
                if (low[neighbor] > tin[node]) {
                    // Check if this is the specific edge (c, d)
                    if ((node == c && neighbor == d) || (node == d && neighbor == c)) {
                        return true;
                    }
                }
            } else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1)