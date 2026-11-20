import java.util.*;

class Solution {
    public static int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Min-Heap based on cost {cost, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] dist = new int[n][m];

        // Initialize distances with infinity
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        pq.add(new int[]{grid[0][0], 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            // If we reached the bottom-right cell
            if (r == n - 1 && c == m - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newCost = cost + grid[nr][nc];

                    if (newCost < dist[nr][nc]) {
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{newCost, nr, nc});
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}