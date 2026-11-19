class Solution {
    static int timer = 1;

    static boolean isBridge(int V, int[][] edges, int c, int d) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        timer = 1;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited, tin, low, c, d)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] tin, int[] low, int c, int d) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) continue;

            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adj, visited, tin, low, c, d)) {
                    return true;
                }

                low[node] = Math.min(low[node], low[neighbor]);

                // Bridge condition: low[neighbor] > tin[node]
                if (low[neighbor] > tin[node]) {
                    // Check if this is the specific edge (c, d)
                    if ((node == c && neighbor == d) || (node == d && neighbor == c)) {
                        return true;
                    }
                }
            } else {
                low[node] = Math.min(low[node], tin[neighbor]);
            }
        }
        return false;
    }
}