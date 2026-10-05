import java.util.*;

class Solution {
    private int n, m;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int countCoordinates(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        boolean[][] p = new boolean[n][m];
        boolean[][] q = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            dfs(mat, 0, j, p);
        }
        for (int i = 0; i < n; i++) {
            dfs(mat, i, 0, p);
        }

        for (int j = 0; j < m; j++) {
            dfs(mat, n - 1, j, q);
        }
        for (int i = 0; i < n; i++) {
            dfs(mat, i, m - 1, q);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (p[i][j] && q[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] mat, int r, int c, boolean[][] vis) {
        if (vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && mat[nr][nc] >= mat[r][c]) {
                dfs(mat, nr, nc, vis);
            }
        }
    }
}