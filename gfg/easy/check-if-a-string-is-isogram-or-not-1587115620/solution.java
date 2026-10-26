class Solution {
    static boolean isIsogram(String data) {
        boolean[] seen = new boolean[26];
        for (char c : data.toCharArray()) {
            if (seen[c - 'a']) return false;
            seen[c - 'a'] = true;
        }
        return true;
    }
}