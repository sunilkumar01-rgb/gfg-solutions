import java.util.Random;

class Solution {
    int[] prefixSums;
    int totalSum;
    Random rand;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int currentSum = 0;
        
        for (int i = 0; i < w.length; i++) {
            currentSum += w[i];
            prefixSums[i] = currentSum;
        }
        
        totalSum = currentSum;
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(totalSum) + 1; 
        
        int left = 0, right = prefixSums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}