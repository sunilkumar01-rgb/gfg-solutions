class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        long sum = 0;
        int n = arr.length;

        for (int end = 0; end < n; end++) {
            sum += arr[end];

            while (sum > s && start < end) {
                sum -= arr[start];
                start++;
            }

            if (sum == s) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }
}