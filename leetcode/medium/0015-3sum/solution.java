import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            int a = nums[i];
            int req = -a;
            
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = nums[j] + nums[k];
                
                if (sum == req) {
                    List<Integer> l1 = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(l1);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (sum > req) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        
        return ans;
    }
}