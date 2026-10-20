class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            ans.append(sb.reverse());

            if (i < words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}