class Solution {
    public static int countWays(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int MOD = 1000000007;
        int[] dp = new int[m + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i) == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }
        return dp[m];
    }
}