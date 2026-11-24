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
**Submitted:** 2026-11-24T17:00:57.901Z  

```java
import java.util.*;

class Solution {
    public int countSCC(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Order nikaalo (Finish time ke hisaab se)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Step 2: Graph ko reverse karo
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) revAdj.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                revAdj.get(neighbor).add(i);
            }
        }

        // Step 3: Stack se nodes pop karke reversed graph par DFS chalao
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                sccCount++;
                dfs2(node, revAdj, visited);
            }
        }

        return sccCount;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs1(neighbor, adj, visited, stack);
        }
        stack.push(node);
    }

    private void dfs2(int node, ArrayList<ArrayList<Integer>> revAdj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : revAdj.get(node)) {
            if (!visited[neighbor]) dfs2(neighbor, revAdj, visited);
        }
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1)