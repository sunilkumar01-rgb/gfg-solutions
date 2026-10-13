class Solution {
    int maxTripletProduct(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        long option1 = (long) arr[n - 1] * arr[n - 2] * arr[n - 3];
        long option2 = (long) arr[0] * arr[1] * arr[n - 1];

        return (int) Math.max(option1, option2);
    }
}