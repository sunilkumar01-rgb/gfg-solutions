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