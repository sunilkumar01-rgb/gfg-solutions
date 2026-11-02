class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solve(0, board, ans, n);
        return ans;
    }
    
    private void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}