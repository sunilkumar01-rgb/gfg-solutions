# Dijkstra Algorithm

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a connected, weighted, undirected graph with  **V**  vertices and no negative edge weights, represented by an adjacency list  **adj[][][]**, and a source vertex src, calculate the shortest distance from  **src**  to every vertex in the graph.

Each adj[u] contains pairs [v, wt], where v is an adjacent vertex and wt is the weight of the edge connecting vertices u and v.

Return an array of integers where the ith element represents the shortest distance from the source vertex src to vertex i.

 **Note:** It is guaranteed that all the shortest distance will fit in a 32-bit integer.

 **Examples:** 

```
Input: adj[][][] = [[[1, 1], [2, 6]], [[0, 1], [2, 3]], [[0, 6], [1, 3]]], src = 2
Output: [4, 3, 0]
Explanation:

Shortest Paths:
For 2 to 0 minimum distance will be 4. By following path 2 -> 1 -> 0
For 2 to 1 minimum distance will be 3. By following path 2 -> 1
For 2 to 2 minimum distance will be 0. By following path 2 -> 2

```

```
Input: adj[][][] = [[[1, 4], [2, 8]], [[0, 4], [4, 6]], [[0, 8], [3, 2]], [[2, 2], [4, 10]], [[1, 6], [3, 10]]], src = 0
Output: [0, 4, 8, 10, 10]
Explanation: 

Shortest Paths: 
For 0 to 1 minimum distance will be 4. By following path 0 -> 1
For 0 to 2 minimum distance will be 8. By following path 0 -> 2
For 0 to 3 minimum distance will be 10. By following path 0 -> 2 -> 3 
For 0 to 4 minimum distance will be 10. By following path 0 -> 1 -> 4
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-24T17:07:39.687Z  

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) continue;

            for (ArrayList<Integer> edge : adj.get(u)) {
                int v = edge.get(0);
                int weight = edge.get(1);

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ans.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }

        return ans;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1)