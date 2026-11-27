import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{nums.get(i).get(0), i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int min = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];
            
            if (max - min < rangeEnd - rangeStart) {
                rangeStart = min;
                rangeEnd = max;
            }
            
            if (elemIdx + 1 < nums.get(listIdx).size()) {
                int nextVal = nums.get(listIdx).get(elemIdx + 1);
                max = Math.max(max, nextVal);
                pq.add(new int[]{nextVal, listIdx, elemIdx + 1});
            }
        }
        
        return new int[]{rangeStart, rangeEnd};
    }
}