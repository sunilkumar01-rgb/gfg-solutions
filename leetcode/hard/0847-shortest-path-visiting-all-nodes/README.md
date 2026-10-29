# Shortest Path Visiting All Nodes

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You have an undirected, connected graph of `n` nodes labeled from `0` to `n - 1`. You are given an array `graph` where `graph[i]` is a list of all the nodes connected with node `i` by an edge.

Return  *the length of the shortest path that visits every node*. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

 **Example 1:** 

```
Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]

```

 **Example 2:** 

```
Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]

```

 

 **Constraints:** 

- n == graph.length
- 1 <= n <= 12
- 0 <= graph[i].length < n
- graph[i] does not contain i.
- If graph[a] contains b, then graph[b] contains a.
- The input graph is always connected.

## Solution

**Language:** Java  
**Runtime:** 12 ms (beats 38.73%)  
**Memory:** 46 MB (beats 83.33%)  
**Submitted:** 2026-10-29T16:25:37.007Z  

```java
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i, 0}); // {node, mask, distance}
            visited[i][1 << i] = true;
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], mask = curr[1], dist = curr[2];
            
            if (mask == (1 << n) - 1) return dist; // All nodes visited
            
            for (int v : graph[u]) {
                int nextMask = mask | (1 << v);
                if (!visited[v][nextMask]) {
                    visited[v][nextMask] = true;
                    q.offer(new int[]{v, nextMask, dist + 1});
                }
            }
        }
        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/shortest-path-visiting-all-nodes/)