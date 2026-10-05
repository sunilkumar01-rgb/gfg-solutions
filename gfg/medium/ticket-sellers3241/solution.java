import java.util.*;

class Solution {
    public int maxAmount(int[] arr, int k) {
        long MOD = 1_000_000_007;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int tickets : arr) {
            maxHeap.add(tickets);
        }

        long total = 0;

        while (k > 0 && !maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            total = (total + current) % MOD;

            if (current - 1 > 0) {
                maxHeap.add(current - 1);
            }
            k--;
        }

        return (int) total;
    }
}