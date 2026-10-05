class Solution {
    public long countKdivPairs(int[] arr, int k) {
        long[] freq = new long[k];
        for (int num : arr) {
            freq[num % k]++;
        }

        long count = 0;

        count += freq[0] * (freq[0] - 1) / 2;

        for (int i = 1; i <= k / 2; i++) {
            if (i == k - i) {
                count += freq[i] * (freq[i] - 1) / 2;
            } else {
                count += freq[i] * freq[k - i];
            }
        }

        return count;
    }
}