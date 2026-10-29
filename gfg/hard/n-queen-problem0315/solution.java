class Solution {
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] board = new int[n];
        solve(0, board, ans, n);
        return ans;
    }

    static void solve(int col, int[] board, ArrayList<ArrayList<Integer>> ans, int n) {
        if (col == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) temp.add(board[i] + 1);
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;
                solve(col + 1, board, ans, n);
            }
        }
    }

    static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }
}