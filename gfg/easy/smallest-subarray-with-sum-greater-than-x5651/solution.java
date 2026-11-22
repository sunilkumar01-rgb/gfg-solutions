class Solution {
    public static int smallestSubWithSum(int arr[], int x) {
        int n = arr.length;
        int minLen = n + 1;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += arr[right];

            while (currentSum > x && left <= right) {
                minLen = Math.min(minLen, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }

        return minLen == n + 1 ? 0 : minLen;
    }
}