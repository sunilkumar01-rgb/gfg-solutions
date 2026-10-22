class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];
        int[] sorted = score.clone();
        Arrays.sort(sorted);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) map.put(sorted[i], "Gold Medal");
            else if (i == n - 2) map.put(sorted[i], "Silver Medal");
            else if (i == n - 3) map.put(sorted[i], "Bronze Medal");
            else map.put(sorted[i], String.valueOf(n - i));
        }
        for (int i = 0; i < n; i++) res[i] = map.get(score[i]);
        return res;
    }
}