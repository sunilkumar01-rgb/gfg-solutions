class Solution {
    static int maxWater(int[] arr) {
        int left = 0, right = arr.length - 1;
        int maxWater = 0;

        while (left < right) {
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            maxWater = Math.max(maxWater, height * width);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}