class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();

        int maxHeight = 0;

        for (int[] square : positions) {
            int left = square[0];
            int right = left + square[1];
            int side = square[1];

            int baseHeight = 0;

            for (int[] interval : intervals) {
                if (left < interval[1] && right > interval[0]) {
                    baseHeight = Math.max(baseHeight, interval[2]);
                }
            }

            int height = baseHeight + side;
            intervals.add(new int[]{left, right, height});

            maxHeight = Math.max(maxHeight, height);
            ans.add(maxHeight);
        }

        return ans;
    }
}