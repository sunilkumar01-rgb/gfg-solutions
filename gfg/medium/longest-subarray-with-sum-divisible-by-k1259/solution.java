class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 

        int maxLen = 0;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = (int)(sum % k);

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) {
                maxLen = Math.max(maxLen, i - map.get(rem));
            } else {
                map.put(rem, i);
            }
        }
        return maxLen;
    }
}