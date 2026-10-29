# Rat in Maze

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary matrix  **maze[][]**  of size **n × n**  containing values  **0**  and  **1**, find all possible paths for a rat to travel from the source cell (0, 0) to the destination cell (n - 1, n - 1). The rat can move in four directions: up(U), down(D), left(L), and right(R).

- 1 represents an open cell through which the rat can move.
- 0 represents a blocked cell that cannot be traversed.

The rat can move only through open cells and cannot visit the same cell more than once in a path. Return all valid paths as strings consisting of 'U', 'D', 'L', and 'R', representing the sequence of moves taken by the rat.

 **Note:**  Return the paths in lexicographically increasing order. If no valid path exists, return an empty list.

 **Examples:** 

```
Input: maze[][] = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}
Output: ["DDRDRR", "DRDDRR"]
Explanation: There are two valid paths from the source cell (0, 0) to the destination cell (3, 3).

```

```
Input: maze[][] = [[1, 0], [1, 0]]
Output: []
Explanation: No path exists as the destination cell (1, 1) is blocked.

```

 **Constraints:** 
2 ≤ n ≤ 5
0 ≤ maze[i][j] ≤ 1

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T16:10:47.006Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1)