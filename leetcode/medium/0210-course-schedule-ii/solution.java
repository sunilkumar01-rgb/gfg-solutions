class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        int[] ans = new int[numCourses];
        int idx = 0;
        
        while (!q.isEmpty()) {
            int course = q.poll();
            ans[idx++] = course;
            
            for (int next : adj.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) q.add(next);
            }
        }
        return idx == numCourses ? ans : new int[0];
    }
}
