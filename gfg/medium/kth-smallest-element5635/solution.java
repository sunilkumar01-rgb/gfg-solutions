class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}