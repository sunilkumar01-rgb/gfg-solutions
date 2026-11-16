class Solution {
    public ArrayList<Integer> diffArray(int[] arr, int[][] opr) {

        int n = arr.length;
        int[] diff = new int[n + 1];

        for (int[] q : opr) {
            int l = q[0];
            int r = q[1];
            int v = q[2];

            diff[l] += v;
            diff[r + 1] -= v;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += diff[i];
            ans.add(arr[i] + sum);
        }

        return ans;
    }
}