import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost, int w) {
        int n = cost.length;
        int[] dp = new int[w + 1];

        // dp array ko infinity se initialize karo
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0 weight ke liye 0 cost

        // Standard Unbounded Knapsack logic
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                // Agar current packet available hai aur uski weight i se kam/barabar hai
                if (j <= i && cost[j - 1] != -1 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + cost[j - 1]);
                }
            }
        }

        // Agar dp[w] infinity hi raha, matlab exact weight banana possible nahi hai
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}