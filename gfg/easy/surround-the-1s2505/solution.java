class Solution {
    public int countSurroundedOnes(int[][] matrix) {
        // code here
        int row=matrix.length;
        int col=matrix[0].length;
        int ans=0;
        int[] row_arr={-1,1,0,0,-1,-1,1,1};
        int[] col_arr={0,0,-1,1,-1,1,-1,1};
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0)
                continue;
                int count=0;
            for(int k=0;k<8;k++){
                int r=i+row_arr[k];
                int c=j+col_arr[k];
                
                if(r>=0 && c>=0 && r<row && c<col && matrix[r][c]==0){
                    count++;
                }
            }
            if(count!=0 && count%2==0)
            ans++;
            }
        }
        return ans;
    }
}