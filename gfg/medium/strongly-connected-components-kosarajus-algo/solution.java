class Solution {
    public int countSCC(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // First DFS: Store vertices by finishing time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Reverse the graph
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                rev.get(v).add(i);
            }
        }

        // Second DFS: Count SCCs
        Arrays.fill(visited, false);
        int count = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                dfs2(node, rev, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfs1(v, adj, visited, stack);
            }
        }

        stack.push(node);
    }

    private void dfs2(int node, ArrayList<ArrayList<Integer>> adj,
                      boolean[] visited) {
        visited[node] = true;

        for (int v : adj.get(node)) {
            if (!visited[v]) {
                dfs2(v, adj, visited);
            }
        }
    }
}