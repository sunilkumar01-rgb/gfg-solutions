class Solution {
    public int orangesRot(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();

                for (int[] d : dirs) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if (r >= 0 && r < n && c >= 0 && c < m && mat[r][c] == 1) {
                        mat[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}