class Solution {
    public int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    count++;
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 'L') {
            return;
        }

        // Mark as visited (water) so we don't visit again
        grid[i][j] = 'W';

        // 8 directions (horizontal, vertical, diagonal)
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            dfs(grid, i + rowDir[k], j + colDir[k], n, m);
        }
    }
}