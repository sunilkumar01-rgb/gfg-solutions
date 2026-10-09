class Solution {
    public static int findEquilibrium(int[] arr) {
        long total = 0;
        for (int num : arr) total += num;

        long leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            long rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}