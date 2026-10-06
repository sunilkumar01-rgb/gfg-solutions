class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int ans=sum;
        int index=0;
        for(int i=k;i<arr.length;i++){
            sum+=arr[i]-arr[index];
            ans=Math.max(ans,sum);
            index++;
        }
        return ans;
    }
}