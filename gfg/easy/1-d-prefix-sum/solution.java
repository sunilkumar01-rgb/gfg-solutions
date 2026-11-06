class Solution {
    public ArrayList<Integer> prefSum(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();

        int sum = 0;

        for (int num : arr) {
            sum += num;
            ans.add(sum);
        }

        return ans;
    }
}