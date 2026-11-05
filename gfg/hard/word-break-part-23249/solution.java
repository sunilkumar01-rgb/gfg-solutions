class Solution {
    public ArrayList<String> wordBreak(String[] dict, String s) {
        HashSet<String> set = new HashSet<>(Arrays.asList(dict));
        ArrayList<String>[] dp = new ArrayList[s.length() + 1];

        return solve(0, s, set, dp);
    }

    private ArrayList<String> solve(int index, String s,
                                    HashSet<String> set,
                                    ArrayList<String>[] dp) {

        if (dp[index] != null) {
            return dp[index];
        }

        ArrayList<String> ans = new ArrayList<>();

        if (index == s.length()) {
            ans.add("");
            return dp[index] = ans;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);

            if (set.contains(word)) {
                ArrayList<String> suffixes = solve(i, s, set, dp);

                for (String suffix : suffixes) {
                    if (suffix.isEmpty()) {
                        ans.add(word);
                    } else {
                        ans.add(word + " " + suffix);
                    }
                }
            }
        }

        return dp[index] = ans;
    }
}