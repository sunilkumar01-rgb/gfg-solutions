class Solution {
    public int maxCharGap(String s) {
        HashMap<Character, Integer> first = new HashMap<>();
        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first.containsKey(c)) {
                maxGap = Math.max(maxGap, i - first.get(c) - 1);
            } else {
                first.put(c, i);
            }
        }

        return maxGap;
    }
}