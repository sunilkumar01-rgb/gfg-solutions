# Word Search

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a matrix  **mat[][]**  of size  **n*m**  containing english alphabets and a string word. Check if the word exists on the mat[][] or not.

- The word can be constructed by using letters from adjacent cells, either horizontally or vertically.
- The same cell cannot be used more than once.

 **Examples :** 

```
Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation: Word "GEEK" can be found in the given grid as follows.

```

```
Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation: Word "GEEK" cannot be found in the given grid.

```

```
Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation: There are multiple ways to construct the word "AB".

```

 **Constraints:** 
1 ≤ n, m ≤ 6
1 ≤ word.size() ≤ 15
mat[] and word contain bot lower case and uppercase English characters

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-15T13:59:59.596Z  

```java

class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] mat, String word,
                int i, int j, int idx) {

        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 ||
            i >= mat.length || j >= mat[0].length ||
            mat[i][j] != word.charAt(idx)) {
            return false;
        }

        char ch = mat[i][j];
        mat[i][j] = '#';

        boolean found =
            dfs(mat, word, i + 1, j, idx + 1) ||
            dfs(mat, word, i - 1, j, idx + 1) ||
            dfs(mat, word, i, j + 1, idx + 1) ||
            dfs(mat, word, i, j - 1, idx + 1);

        mat[i][j] = ch;

        return found;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/word-search/1)