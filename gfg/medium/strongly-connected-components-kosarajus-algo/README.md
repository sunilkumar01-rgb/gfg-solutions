# Count Strongly Connected Components

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a directed graph with  **V**  vertices labeled from  **0**  to  **V - 1**, represented by an adjacency list  **adj**, find number of strongly connected components (SCCs) in the graph.

A strongly connected component is a maximal set of vertices such that every vertex is reachable from every other vertex in the same component.

 **Examples:** 

```
Input: adj[][] = [[1], [2], [0, 3], [4], [3, 5], []]
Output: 3
Explanation: The strongly connected components are: {0, 1, 2},{3, 4} and {5}. Therefore, the total number of SCCs is 3.
 
```

```
Input: adj[][] = [[1], [2], [0]]
Output: 1
Explanation: All of the nodes are connected to each other. So, there's only one SCC.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T16:21:20.377Z  

```java
class Solution {
    public int countSCC(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // First DFS: Store vertices by finishing time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Reverse the graph
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                rev.get(v).add(i);
            }
        }

        // Second DFS: Count SCCs
        Arrays.fill(visited, false);
        int count = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                dfs2(node, rev, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfs1(v, adj, visited, stack);
            }
        }

        stack.push(node);
    }

    private void dfs2(int node, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfs2(v, adj, visited);
            }
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1)