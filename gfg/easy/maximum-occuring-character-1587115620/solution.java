class Solution {
    public static char getMaxOccuringChar(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int max = 0;
        char ans = 'a';

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ans = (char) (i + 'a');
            }
        }

        return ans;
    }
}