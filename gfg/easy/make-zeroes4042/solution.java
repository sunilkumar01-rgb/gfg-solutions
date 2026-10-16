class Solution {
	void makeZeros(int[][] mat) {
		// code here
		int row = mat.length;
		int col = mat[0].length;
		int [][] ans = new int[row][col];
		
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				ans[i][j] = mat[i][j];
			}
		}
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				
				if (mat[i][j] == 0) {
					int sum = 0;
					if (i - 1 >= 0) {
						sum += mat[i - 1][j];
						ans[i - 1][j] = 0;
					}
					if (i + 1<row) {
						sum += mat[i + 1][j];
						ans[i + 1][j] = 0;
					}
					if (j - 1 >= 0) {
						sum += mat[i][j - 1];
						ans[i][j - 1] = 0;
					}
					if (j + 1<col) {
						sum += mat[i][j + 1];
						ans[i][j + 1] = 0;
					}
					ans[i][j] = sum;
				}
			}
		}
		for (int i = 0; i<row; i++) {
			for (int j = 0; j<col; j++) {
				mat[i][j] = ans[i][j];
			}
		}
	}
}
