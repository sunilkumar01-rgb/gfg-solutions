class Solution {
    void booleanMatrix(int mat[][]) {
       // code here
        int m = mat.length;
                int n = mat[0].length;

                boolean[] row = new boolean[m];
                boolean[] col = new boolean[n];

                //Find  ones
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {

                        if (mat[i][j] == 1) {
                            row[i] = true;
                            col[j] = true;
                        }
                    }
                }

                //  required elements to one
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {

                        if (row[i] || col[j]) {
                            mat[i][j] = 1;
                        }
                    }
                }


    }
}