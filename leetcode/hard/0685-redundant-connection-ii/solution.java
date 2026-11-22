class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;
        
        // Step 1: Check karo kisi node ke 2 parents toh nahi hain
        for (int[] edge : edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                candidate1 = new int[]{parent[edge[1]], edge[1]};
                candidate2 = new int[]{edge[0], edge[1]};
                // Assume karo ki candidate2 galat edge hai, usko hata kar dekhte hain
                edge[1] = 0; 
            }
        }
        
        // Step 2: Union-Find initialize karo
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        // Step 3: Cycle check karo
        for (int[] edge : edges) {
            if (edge[1] == 0) continue; // Skip the candidate2 edge
            int u = edge[0], v = edge[1];
            int rootU = find(parent, u), rootV = find(parent, v);
            
            if (rootU == rootV) {
                // Agar cycle mili
                if (candidate1 != null) {
                    return candidate1; // Matlab pehla parent wala edge galat tha
                }
                return edge; // Koi 2-parent issue nahi tha, yeh cycle wala edge hai
            }
            parent[rootU] = rootV;
        }
        
        return candidate2; // Cycle nahi mili, matlab doosra parent wala edge galat tha
    }
    
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}