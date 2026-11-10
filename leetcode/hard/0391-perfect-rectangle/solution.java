class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE, y2 = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<>();
        long area = 0;
        
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            
            area += (long)(rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            String p1 = rect[0] + " " + rect[1];
            String p2 = rect[0] + " " + rect[3];
            String p3 = rect[2] + " " + rect[1];
            String p4 = rect[2] + " " + rect[3];
            
            if (!set.add(p1)) set.remove(p1);
            if (!set.add(p2)) set.remove(p2);
            if (!set.add(p3)) set.remove(p3);
            if (!set.add(p4)) set.remove(p4);
        }
        
        if (set.size() != 4 || !set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || 
            !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2)) {
            return false;
        }
        
        return area == (long)(x2 - x1) * (y2 - y1);
    }
}