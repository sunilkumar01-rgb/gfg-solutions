class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i][j] = Player 1 can get max score from nums[i...j]
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // Player 1 ka choice: left uthao ya right uthao
                // Player 2 optimal khelega, isliye min wala subtract hoga
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        
        // Agar Player 1 ka score >= 0 hai, matlab wo jeet sakta hai
        return dp[0][n - 1] >= 0;
    }
}