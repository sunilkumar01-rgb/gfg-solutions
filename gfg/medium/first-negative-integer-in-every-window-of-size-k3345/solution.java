class Solution {
    public List<Integer> firstNegInt(int[] arr, int k) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) queue.add(i);

            if (i >= k - 1) {
                while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                    queue.poll();
                }
                ans.add(queue.isEmpty() ? 0 : arr[queue.peek()]);
            }
        }

        return ans;
    }
}