# Redundant Connection II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

In this problem, a rooted tree is a  **directed**  graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with `n` nodes (with distinct values from `1` to `n`), with one additional directed edge added. The added edge has two different vertices chosen from `1` to `n`, and was not an edge that already existed.

The resulting graph is given as a 2D-array of `edges`. Each element of `edges` is a pair `[ui, vi]` that represents a  **directed**  edge connecting nodes `ui` and `vi`, where `ui` is a parent of child `vi`.

Return  *an edge that can be removed so that the resulting graph is a rooted tree of*  `n`  *nodes*. If there are multiple answers, return the answer that occurs last in the given 2D-array.

 

Original
Java
 **Example 1:** 

```
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

```

 **Example 2:** 

```
Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]

```

 

 **Constraints:** 

- n == edges.length
- 3 <= n <= 1000
- edges[i].length == 2
- 1 <= ui, vi <= n
- ui != vi

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 100.00%)  
**Memory:** 44.5 MB (beats 86.96%)  
**Submitted:** 2026-11-22T17:17:03.283Z  

```java
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;
        
        // Step 1: Check karo kisi node ke 2 parents toh nahi hain
        for (int[] edge : edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                candidate1 = new int[]{parent[edge[1]], edge[1]};
                candidate2 = new int[]{edge[0], edge[1]};
                // Assume karo ki candidate2 galat edge hai, usko hata kar dekhte hain
                edge[1] = 0; 
            }
        }
        
        // Step 2: Union-Find initialize karo
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        // Step 3: Cycle check karo
        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip the candidate2 edge
            int u = edge[0], v = edge[1];
            int rootU = find(parent, u), rootV = find(parent, v);
            
            if (rootU == rootV) {
                // Agar cycle mili
                if (candidate1 != null) {
                    return candidate1; // Matlab pehla parent wala edge galat tha
                }
                return edge; // Koi 2-parent issue nahi tha, yeh cycle wala edge hai
            }
            parent[rootU] = rootV;
        }
        
        return candidate2; // Cycle nahi mili, matlab doosra parent wala edge galat tha
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/redundant-connection-ii/)