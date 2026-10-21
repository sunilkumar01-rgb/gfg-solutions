class Solution {
    public int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] ans = new int[n][m];

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = img[i][j];
                int count = 1;

                for (int k = 0; k < 8; k++) {
                    int newRow = i + row[k];
                    int newCol = j + col[k];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        sum += img[newRow][newCol];
                        count++;
                    }
                }

                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}