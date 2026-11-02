class Solution {
    public int josephus(int n, int k) {
        if (n == 1) return 1;
        // Recursive formula for 1-based indexing
        return (josephus(n - 1, k) + k - 1) % n + 1;
    }
}