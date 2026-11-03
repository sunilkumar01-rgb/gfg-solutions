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

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-03T18:55:00.669Z  

```cpp
class Solution {
  public:
    int primMST(vector<vector<vector<int>>> &adj) {
        int V = adj.size();

        vector<int> key(V, INT_MAX);
        vector<bool> mst(V, false);

        priority_queue<
            pair<int, int>,
            vector<pair<int, int>>,
            greater<pair<int, int>>
        > pq;

        key[0] = 0;
        pq.push({0, 0});

        int sum = 0;

        while (!pq.empty()) {
            int wt = pq.top().first;
            int u = pq.top().second;
            pq.pop();

            if (mst[u]) continue;

            mst[u] = true;
            sum += wt;

            for (auto it : adj[u]) {
                int v = it[0];
                int weight = it[1];

                if (!mst[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.push({weight, v});
                }
            }
        }

        return sum;
    }
};
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1)