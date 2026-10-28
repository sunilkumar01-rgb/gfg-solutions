class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) diff += count[i];
        }

        return diff <= k;
    }
}