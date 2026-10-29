# N-Queen Problem

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

The N-Queens puzzle is the problem of placing N queens on an N * N chessboard such that no two queens attack each other. Two queens attack each other if they are placed in the same row, the same column, or the same diagonal.

Given an integer  **n** representing the number of queens, find all distinct solutions to this puzzle. Each solution should be represented as an array of size n, where the **ith**  element (1-based indexing) denotes the column position of the queen placed in the  **ith** row.

 **Note:**  You may return the solutions in any order.

 **Examples:** 

```
Input: n = 1
Output: [1]
Explanation: Only one queen can be placed in the single cell available.
```

```
Input: n = 4
Output: [[2, 4, 1, 3], [3, 1, 4, 2]]
Explanation: There are 2 possible solutions for n = 4.

```

```
Input: n = 3
Output: []
Explanation: There are no possible solutions for n = 3.
```

**Constraints:
**1 ≤ n ≤ 10

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-29T16:11:36.603Z  

```java
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
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1)