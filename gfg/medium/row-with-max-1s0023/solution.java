class Solution {
    public int rowWithMax1s(int[][] arr) {
        int maxCount = 0;
        int ansRow = -1;
        int cols = arr[0].length;

        for (int i = 0; i < arr.length; i++) {
            int currentCount = 0;
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1) {
                    currentCount = cols - j; // Sorted hai, toh baaki sab 1 hi honge
                    break;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                ansRow = i;
            }
        }
        return ansRow;
    }
}