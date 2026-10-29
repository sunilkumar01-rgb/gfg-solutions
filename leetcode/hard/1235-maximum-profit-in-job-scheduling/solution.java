class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // Sort by end time
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        
        for (int i = 1; i < n; i++) {
            int include = jobs[i][2];
            int low = 0, high = i - 1, lastCompatible = -1;
            
            // Find the latest job that ends before current job starts
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    lastCompatible = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (lastCompatible != -1) include += dp[lastCompatible];
            dp[i] = Math.max(dp[i - 1], include);
        }
        return dp[n - 1];
    }
}