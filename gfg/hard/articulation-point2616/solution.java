class Solution {

    static int timer;

    static void dfs(int node, int parent, boolean[] vis,
                    int[] tin, int[] low, boolean[] mark,
                    ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;

        tin[node] = low[node] = timer++;

        int child = 0;

        for (int adjNode : adj.get(node)) {

            if (adjNode == parent)
                continue;

            if (!vis[adjNode]) {

                dfs(adjNode, node, vis, tin, low, mark, adj);

                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] >= tin[node] && parent != -1) {
                    mark[node] = true;
                }

                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[adjNode]);
            }
        }

        if (parent == -1 && child > 1) {
            mark[node] = true;
        }
    }

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[V];
        boolean[] mark = new boolean[V];

        int[] tin = new int[V];
        int[] low = new int[V];

        timer = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (mark[i]) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;
    }
}