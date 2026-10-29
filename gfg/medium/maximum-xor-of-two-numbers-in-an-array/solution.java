class Solution {
    public int maxXor(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[i] ^ arr[j]);
            }
        }

        return max;
    }
}