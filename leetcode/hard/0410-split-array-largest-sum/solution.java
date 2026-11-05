class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        long sum = 0;
        
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        
        long left = max, right = sum;
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (isValid(nums, k, mid)) {
                ans = mid;
                right = mid - 1; // Try to minimize the largest sum
            } else {
                left = mid + 1; // Need more capacity
            }
        }
        return (int) ans;
    }
    
    private boolean isValid(int[] nums, int k, long maxSum) {
        int count = 1;
        long currentSum = 0;
        
        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum) {
                count++;
                currentSum = num;
                if (count > k) return false;
            }
        }
        return true;
    }
}