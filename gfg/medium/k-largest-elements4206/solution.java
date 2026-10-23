class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        ArrayList<Integer> ans = new ArrayList<>(minHeap);
        ans.sort(Collections.reverseOrder());
        return ans;
    }
}