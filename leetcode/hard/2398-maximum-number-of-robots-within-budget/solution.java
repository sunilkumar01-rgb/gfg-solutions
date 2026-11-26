import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        long runningSum = 0;
        int maxRobots = 0;
        
        for (int right = 0; right < n; right++) {
            // Monotonic Deque maintain karo max charge time ke liye
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            runningSum += runningCosts[right];
            
            // Agar cost budget se bahar hai, toh window shrink karo
            while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (runningSum * (right - left + 1)) > budget) {
                runningSum -= runningCosts[left];
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }
                left++;
            }
            
            maxRobots = Math.max(maxRobots, right - left + 1);
        }
        return maxRobots;
    }
}