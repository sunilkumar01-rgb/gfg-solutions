class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }

        return maxLen;
    }
}