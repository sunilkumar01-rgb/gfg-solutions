class Solution {
    public int maxZeros(int[][] arr) {
        int n= arr.length;
        int max_count =0, ans= -1;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[j][i]==0){
                    count++;
                }
            }
            if(count>max_count){
                max_count=count;
                ans=i;
            }
        }
        return ans;
        
    }
}