class Solution {
    public int nthRoot(int n, int m) {
        if (m == 0) return 0; // Edge case
        if (m == 1) return 1;

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = 1;

            for (int i = 0; i < n; i++) {
                power *= mid;
                if (power > m) break; // Overflow aur TLE se bachne ke liye
            }

            if (power == m) return mid;
            else if (power < m) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }
}