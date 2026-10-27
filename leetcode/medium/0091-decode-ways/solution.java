class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            // Ek digit check karo (1 se 9 tak valid)
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            
            // Do digit check karo (10 se 26 tak valid)
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}