import java.util.*;

class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int neighbor : adj.get(node)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}