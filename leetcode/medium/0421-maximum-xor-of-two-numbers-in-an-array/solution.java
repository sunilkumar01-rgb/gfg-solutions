class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0, mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = maxXor | (1 << i);
            
            for (int prefix : set) {
                if (set.contains(prefix ^ temp)) {
                    maxXor = temp;
                    break;
                }
            }
        }
        return maxXor;
    }
}