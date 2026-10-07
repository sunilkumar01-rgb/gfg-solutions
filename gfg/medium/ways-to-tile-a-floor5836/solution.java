class Solution {
    public int numberOfWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        long prev2 = 1;
        long prev1 = 1;

        for (int i = 2; i <= n; i++) {
            long cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }

        return (int) prev1;
    }
}