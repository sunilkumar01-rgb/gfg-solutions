# Articulation Point

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an undirected graph with **V**  vertices.The graph is represented as a 2D array  **edges[][]**, where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v. Return all the articulation points (or cut vertices) in the graph. An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph. 

- The given graph may be disconnected, i.e., it may consist of more than one connected component. 
- If no such point exists, return {-1}.

 **Examples :** 

```
Input: V = 5, edges[][] = [[0, 1], [1, 4], [4, 3], [4, 2], [2, 3]]

Output: [1, 4]
Explanation: Removing the vertex 1 or 4 will disconnects the graph as-
   
```

```
Input: V = 4, edges[][] = [[0, 1], [0, 2]]
Output: [0]
Explanation: Removing the vertex 0 will increase the number of disconnected components to 3.  

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-14T15:04:01.633Z  

```java
class Solution {

    static int timer;

    static void dfs(int node, int parent, boolean[] vis,
                    int[] tin, int[] low, boolean[] mark,
                    ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        tin[node] = low[node] = timer++;

        int child = 0;

        for (int adjNode : adj.get(node)) {

            if (adjNode == parent)
                continue;

            if (!vis[adjNode]) {

                dfs(adjNode, node, vis, tin, low, mark, adj);

                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }

                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[adjNode]);
            }
        }

        if (parent == -1 && child > 1) {
            mark[node] = true;
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        boolean[] mark = new boolean[V];

        int[] tin = new int[V];
        int[] low = new int[V];

        timer = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (mark[i]) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/articulation-point2616/1)