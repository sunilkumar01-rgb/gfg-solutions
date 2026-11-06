class Solution {
    public ArrayList<Integer> rangeSumQueries(int[] arr, int[][] queries) {
        ArrayList<Integer> ans = new ArrayList<>();

        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];

            ans.add(prefix[right + 1] - prefix[left]);
        }

        return ans;
    }
}