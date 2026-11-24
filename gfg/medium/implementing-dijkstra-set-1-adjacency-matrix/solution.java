import java.util.*;

class Solution {
    public ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];

            if (d > dist[u]) continue;

            for (ArrayList<Integer> edge : adj.get(u)) {
                int v = edge.get(0);
                int weight = edge.get(1);

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            ans.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }

        return ans;
    }
}