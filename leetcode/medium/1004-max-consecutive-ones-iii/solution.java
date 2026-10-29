class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLen = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // Agar zeroCount k se bada ho gaya, toh window ko chhota karo
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}