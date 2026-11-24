# Burning Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given the root of a binary tree and a target node, find the minimum time required to burn the entire tree if the target node is set on fire. In one second, the fire spreads from a node to its left child, right child, and parent.

 **Note:**  The tree contains unique values.

 **Examples :** 

```
Input: root = [1, 2, 3, 4, 5, 6, 7], target = 2
  
Output: 3
Explanation: Initially 2 is set to fire at 0 sec 
At 1 sec: Nodes 4, 5, 1 catches fire.
At 2 sec: Node 3 catches fire.
At 3 sec: Nodes 6, 7 catches fire.
It takes 3s to burn the complete tree.
```

```
Input: root = [1, 2, 3, 4, 5, N, 7, 8, N, N, 10], target = 10

Output: 5
Explanation: Initially 10 is set to fire at 0 sec 
At 1 sec: Node 5 catches fire.
At 2 sec: Node 2 catches fire.
At 3 sec: Nodes 1 and 4 catches fire.
At 4 sec: Node 3 and 8 catches fire.
At 5 sec: Node 7 catches fire.
It takes 5s to burn the complete tree.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-24T16:53:16.371Z  

```java
import java.util.*;

class Solution {
    static Node targetNode;

    public static int minTime(Node root, int target) {
        targetNode = null;
        HashMap<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, null, target, parentMap);

        if (targetNode == null) return 0;

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedAny = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // Check Left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                    burnedAny = true;
                }
                // Check Right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                    burnedAny = true;
                }
                // Check Parent
                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.add(parent);
                    burnedAny = true;
                }
            }
            if (burnedAny) time++;
        }
        return time;
    }

    static void buildParentMap(Node root, Node parent, int target, HashMap<Node, Node> parentMap) {
        if (root == null) return;
        parentMap.put(root, parent);
        if (root.data == target) targetNode = root;

        buildParentMap(root.left, root, target, parentMap);
        buildParentMap(root.right, root, target, parentMap);
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/burning-tree/1)