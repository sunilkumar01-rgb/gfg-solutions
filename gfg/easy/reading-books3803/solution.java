class Solution {
    public int maxPoint(int k, int[] arr1, int[] arr2) {
        // code
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            int time=k/arr1[i];
            int points=arr2[i]*time;
            ans=Math.max(ans,points);
        }
        return ans;
    }
}
