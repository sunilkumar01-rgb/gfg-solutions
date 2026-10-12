class Solution {
    public int findMean(int[] arr) {
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (int) (sum / arr.length);
    }
}