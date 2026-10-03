import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);
        
        int prefixSum = 0;
        int ans = 0;
        
        for (int num : nums) {
            prefixSum = ((prefixSum + num) % k + k) % k;
            ans += remainderCount.getOrDefault(prefixSum, 0);
            remainderCount.put(prefixSum, remainderCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return ans;
    }
}