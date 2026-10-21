# Bipartite Graph

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a Graph with  **V**  vertices (Numbered from  **0**  to  **V-1**) and  **E**  edges. Check whether the graph is bipartite or not.

A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color. This means we can divide the graph’s vertices into two distinct sets where:

- All edges connect vertices from one set to vertices in the other set.
- No edges exist between vertices within the same set.

 **Examples:** 

```
Input: V = 3, edges[][] = [[0, 1], [1,2]]

Output: true
Explanation: The given graph can be colored in two colors so, it is a bipartite graph.

```

```
Input: V = 4, edges[][] = [[0, 3], [1, 2], [3, 2], [0, 2]]

Output: false 
Explanation: The given graph cannot be colored in two colors such that color of adjacent vertices differs. 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-21T17:25:07.449Z  

```java
class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

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