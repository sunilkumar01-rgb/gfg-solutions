class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        int n = arr.length;

        if (n >= k) return true;

        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] newDp = new boolean[k];
            newDp[num % k] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    newDp[r] = true;
                    newDp[(r + num % k) % k] = true;
                }
            }
            dp = newDp;

            if (dp[0]) return true;
        }

        return false;
    }
}