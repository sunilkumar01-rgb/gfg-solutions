import java.util.*;

class Solution {
    public int countSCC(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Order nikaalo (Finish time ke hisaab se)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Step 2: Graph ko reverse karo
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) revAdj.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                revAdj.get(neighbor).add(i);
            }
        }

        // Step 3: Stack se nodes pop karke reversed graph par DFS chalao
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                sccCount++;
                dfs2(node, revAdj, visited);
            }
        }

        return sccCount;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) dfs1(neighbor, adj, visited, stack);
        }
        stack.push(node);
    }

    private void dfs2(int node, ArrayList<ArrayList<Integer>> revAdj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : revAdj.get(node)) {
            if (!visited[neighbor]) dfs2(neighbor, revAdj, visited);
        }
    }
}