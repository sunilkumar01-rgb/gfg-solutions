class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEnd;
        
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchInNode(word, index + 1, node.children[i])) return true;
            }
            return false;
        } else {
            return searchInNode(word, index + 1, node.children[c - 'a']);
        }
    }
}