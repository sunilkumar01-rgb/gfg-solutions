class Solution {
    public int sumMatrix(int n, int q) {
        // code here
        int low=Math.max(1,q-n);
        int high=Math.min(n, q-1);
        
        int ans=Math.max(0,high-low+1);
        return ans;
    }
}