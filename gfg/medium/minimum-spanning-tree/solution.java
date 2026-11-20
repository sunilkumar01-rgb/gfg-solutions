import java.util.*;

class Solution {
    static int primMST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        // PriorityQueue stores {weight, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0}); // Start with node 0, weight 0

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            mstWeight += weight;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int neighbor = edge.get(0);
                int edgeWeight = edge.get(1);

                if (!visited[neighbor]) {
                    pq.add(new int[]{edgeWeight, neighbor});
                }
            }
        }

        return mstWeight;
    }
}