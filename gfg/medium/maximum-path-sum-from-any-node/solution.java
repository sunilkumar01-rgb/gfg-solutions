class Solution {
    int maxSum = Integer.MIN_VALUE;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }

    private int solve(Node node) {
        if (node == null) return 0;

        // Left aur Right subtree se maximum sum nikaalo
        // Agar negative aa raha hai, toh 0 lo (matlab us path ko ignore karo)
        int left = Math.max(0, solve(node.left));
        int right = Math.max(0, solve(node.right));

        // Current node ko root maan kar path ka sum
        int currentPathSum = node.data + left + right;

        // Global maxSum update karo
        maxSum = Math.max(maxSum, currentPathSum);

        // Parent ko batao ki is node se guzarne wala best path kya hai
        // Parent ko sirf ek hi side (left ya right) choose karni hoti hai
        return node.data + Math.max(left, right);
    }
}