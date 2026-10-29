class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];
        
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i, 0}); // {node, mask, distance}
            visited[i][1 << i] = true;
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], mask = curr[1], dist = curr[2];
            
            if (mask == (1 << n) - 1) return dist; // All nodes visited
            
            for (int v : graph[u]) {
                int nextMask = mask | (1 << v);
                if (!visited[v][nextMask]) {
                    visited[v][nextMask] = true;
                    q.offer(new int[]{v, nextMask, dist + 1});
                }
            }
        }
        return -1;
    }
}