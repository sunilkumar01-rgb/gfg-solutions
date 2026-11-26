class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // 1-based se 0-based index me convert kiya
        
        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                curr++;
                k -= steps;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    
    private long countSteps(int n, long prefix1, long prefix2) {
        long steps = 0;
        while (prefix1 <= n) {
            steps += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }
}