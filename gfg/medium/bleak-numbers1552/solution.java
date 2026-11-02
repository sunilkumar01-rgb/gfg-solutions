class Solution {
    public boolean isBleak(int n) {
        int start = Math.max(1, n - 30);

        for (int x = start; x < n; x++) {
            if (x + Integer.bitCount(x) == n) {
                return false;
            }
        }

        return true;
    }
}