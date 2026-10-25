# Word Search II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an `m x n` `board` of characters and a list of strings `words`, return  *all words on the board*.

Each word must be constructed from letters of sequentially adjacent cells, where  **adjacent cells**  are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

 **Example 1:** 

```
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

```

 **Example 2:** 

```
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

```

 

 **Constraints:** 

- m == board.length
- n == board[i].length
- 1 <= m, n <= 12
- board[i][j] is a lowercase English letter.
- 1 <= words.length <= 3 * 104
- 1 <= words[i].length <= 10
- words[i] consists of lowercase English letters.
- All the strings of words are unique.

## Solution

**Language:** Java  
**Runtime:** 234 ms (beats 31.63%)  
**Memory:** 48.9 MB (beats 20.04%)  
**Submitted:** 2026-10-25T17:34:10.393Z  

```java
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }
        return ans;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> ans) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            ans.add(p.word);
            p.word = null; // avoid duplicates
        }
        
        board[i][j] = '#';
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                dfs(board, x, y, p, ans);
            }
        }
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                if (p.next[c - 'a'] == null) p.next[c - 'a'] = new TrieNode();
                p = p.next[c - 'a'];
            }
            p.word = w;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-search-ii/)