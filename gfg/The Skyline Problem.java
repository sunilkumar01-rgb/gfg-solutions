class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        
        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]}); // Start point with negative height
            points.add(new int[]{b[1], b[2]});  // End point with positive height
        }
        
        Collections.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1);
        int prevMax = 0;
        
        for (int[] p : points) {
            if (p[1] < 0) {
                map.put(-p[1], map.getOrDefault(-p[1], 0) + 1);
            } else {
                int count = map.get(p[1]);
                if (count == 1) map.remove(p[1]);
                else map.put(p[1], count - 1);
            }
            
            int currMax = map.firstKey();
            if (currMax != prevMax) {
                ans.add(Arrays.asList(p[0], currMax));
                prevMax = currMax;
            }
        }
        return ans;
    }
}