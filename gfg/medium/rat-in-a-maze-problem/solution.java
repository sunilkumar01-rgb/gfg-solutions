class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        if (maze[0][0] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, maze, visited, "", result, n);

        return result;
    }

    private void solve(int row, int col, int[][] maze,
                       boolean[][] visited, String path,
                       ArrayList<String> result, int n) {

        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        visited[row][col] = true;

        // D = Down
        if (row + 1 < n && maze[row + 1][col] == 1
                && !visited[row + 1][col]) {
            solve(row + 1, col, maze, visited,
                  path + "D", result, n);
        }

        // L = Left
        if (col - 1 >= 0 && maze[row][col - 1] == 1
                && !visited[row][col - 1]) {
            solve(row, col - 1, maze, visited,
                  path + "L", result, n);
        }

        // R = Right
        if (col + 1 < n && maze[row][col + 1] == 1
                && !visited[row][col + 1]) {
            solve(row, col + 1, maze, visited,
                  path + "R", result, n);
        }

        // U = Up
        if (row - 1 >= 0 && maze[row - 1][col] == 1
                && !visited[row - 1][col]) {
            solve(row - 1, col, maze, visited,
                  path + "U", result, n);
        }

        visited[row][col] = false;
    }
}