class Solution {
    public int maxConsecBits(int[] arr) {
        int ans = 1;
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            int el = arr[i];
            int prev = arr[i - 1];

            if (el == prev) {
                count++;
            } else {
                count = 1;
            }

            if (count > ans) {
                ans = count;
            }
        }

        return ans;
    }
}