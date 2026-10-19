class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        for (int num : count.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}