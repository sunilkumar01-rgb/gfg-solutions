class Solution {
    static int trailingZeroes(int N) {
        int count = 0;
        while (N > 0) {
            N /= 5;
            count += N;
        }
        return count;
    }
}