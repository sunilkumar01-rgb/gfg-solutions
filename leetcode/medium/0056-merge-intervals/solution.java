class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> ans = new ArrayList<>();
        int[] current = intervals[0];
        ans.add(current);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                ans.add(current);
            }
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}