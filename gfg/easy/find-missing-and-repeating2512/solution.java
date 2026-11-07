class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;

        long sum = 0;
        long squareSum = 0;

        for (int num : arr) {
            sum += num;
            squareSum += (long) num * num;
        }

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2L * n + 1) / 6;

        long diff = sum - expectedSum;
        long squareDiff = squareSum - expectedSquareSum;

        long sumRM = squareDiff / diff;

        long repeating = (diff + sumRM) / 2;
        long missing = repeating - diff;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) repeating);
        ans.add((int) missing);

        return ans;
    }
}