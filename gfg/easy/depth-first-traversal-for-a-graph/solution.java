class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfsRec(0, adj, visited, dfs);
        return dfs;
    }

    private void dfsRec(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for (int it : adj.get(node)) {
            if (!visited[it]) {
                dfsRec(it, adj, visited, dfs);
            }
        }
    }
}