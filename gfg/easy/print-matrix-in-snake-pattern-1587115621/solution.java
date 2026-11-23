class Solution {
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Even row: Left to Right
                for (int j = 0; j < n; j++) {
                    ans.add(matrix[i][j]);
                }
            } else {
                // Odd row: Right to Left
                for (int j = n - 1; j >= 0; j--) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}