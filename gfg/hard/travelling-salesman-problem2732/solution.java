class Solution {
    public int tsp(int[][] cost) {
        int n = cost.length;
        int fullMask = (1 << n) - 1;

        int[][] dp = new int[1 << n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, 0, cost, dp, fullMask);
    }

    private int solve(int mask, int pos, int[][] cost,
                      int[][] dp, int fullMask) {

        if (mask == fullMask) {
            return cost[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < cost.length; city++) {
            if ((mask & (1 << city)) == 0) {
                int newCost = cost[pos][city] +
                    solve(mask | (1 << city), city, cost, dp, fullMask);

                ans = Math.min(ans, newCost);
            }
        }

        return dp[mask][pos] = ans;
    }
}