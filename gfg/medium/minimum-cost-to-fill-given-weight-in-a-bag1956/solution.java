class Solution {
    public int minimumCost(int[] cost, int w) {

        int n = cost.length;
        int INF = 1_000_000_000;

        int[] dp = new int[w + 1];
        dp[0] = 0;

        for (int i = 1; i <= w; i++) {
            dp[i] = INF;
        }

        for (int weight = 1; weight <= w; weight++) {

            for (int i = 0; i < n && i < weight; i++) {

                if (cost[i] != -1 &&
                    dp[weight - (i + 1)] != INF) {

                    dp[weight] = Math.min(
                        dp[weight],
                        dp[weight - (i + 1)] + cost[i]
                    );
                }
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}