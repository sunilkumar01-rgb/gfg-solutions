class Solution {
    public int maxCircularSum(int[] arr) {
        int n = arr.length;
        int total = arr[0];

        int maxKadane = arr[0], currMax = arr[0];
        int minKadane = arr[0], currMin = arr[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxKadane = Math.max(maxKadane, currMax);

            currMin = Math.min(arr[i], currMin + arr[i]);
            minKadane = Math.min(minKadane, currMin);

            total += arr[i];
        }

        if (maxKadane < 0) return maxKadane;

        return Math.max(maxKadane, total - minKadane);
    }
}