class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.add(f);
        }
        
        int time = 0;
        while (!pq.isEmpty()) {
            int interval = n + 1;
            List<Integer> temp = new ArrayList<>();
            
            while (interval > 0 && !pq.isEmpty()) {
                temp.add(pq.poll());
                interval--;
            }
            
            for (int f : temp) {
                if (f - 1 > 0) pq.add(f - 1);
            }
            
            time += temp.size() + (pq.isEmpty() ? 0 : interval);
        }
        
        return time;
    }
}