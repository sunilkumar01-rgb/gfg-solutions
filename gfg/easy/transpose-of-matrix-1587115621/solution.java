class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int rows = mat.length;
        int cols = mat[0].length;

        for (int j = 0; j < cols; j++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                row.add(mat[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}