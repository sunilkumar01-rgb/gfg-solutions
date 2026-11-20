class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-Heap based on distance (x^2 + y^2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> 
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        
        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        
        return ans;
    }
}