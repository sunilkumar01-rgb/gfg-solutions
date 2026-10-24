class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        
        int diff = xor & (-xor); // rightmost set bit
        
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) ans[0] ^= num;
            else ans[1] ^= num;
        }
        return ans;
    }
}