# Minimum Spanning Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a weighted, undirected, and connected graph represented by an adjacency list **adj[][][]**, where adj[u] contains pairs [v, w] representing an edge from u to v with weight w.

Find the total weight of its Minimum Spanning Tree (MST) using Prim's Algorithm.

 **Examples:** 

```
Input: adj[][][] = [[[1, 5], [2, 1]], [[0, 5], [2, 3]], [[0, 1], [1, 3]]]
 
Output: 4
Explanation:

The MST contains edges (0, 2) with weight 1 and (1, 2) with weight 3. The total weight is 1 + 3 = 4.
```

```
Input: adj[][][] = [[[1, 5]], [[0, 5]]]

 

Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-20T17:38:33.360Z  

```java
import java.util.*;

class Solution {
    static int primMST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        // PriorityQueue stores {weight, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0}); // Start with node 0, weight 0

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += weight;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int neighbor = edge.get(0);
                int edgeWeight = edge.get(1);

                if (!visited[neighbor]) {
                    pq.add(new int[]{edgeWeight, neighbor});
                }
            }
        }

        return mstWeight;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)