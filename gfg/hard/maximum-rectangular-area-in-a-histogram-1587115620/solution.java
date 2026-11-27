import java.util.Stack;

class Solution {
    public static int getMaxArea(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            // Last me height 0 maan kar saare remaining bars process karenge
            int h = (i == n) ? 0 : arr[i];

            while (!stack.isEmpty() && h < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}