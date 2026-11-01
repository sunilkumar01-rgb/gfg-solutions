class Solution {
    int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;

        int result = solve(root);

        if (maxSum == Integer.MIN_VALUE) {
            return -1;
        }

        return maxSum;
    }

    private int solve(Node node) {
        if (node == null) {
            return 0;
        }

        // If node is a leaf
        if (node.left == null && node.right == null) {
            return node.data;
        }

        int left = solve(node.left);
        int right = solve(node.right);

        // If both children exist, a leaf-to-leaf path is possible
        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, left + right + node.data);

            return node.data + Math.max(left, right);
        }

        // If only one child exists, return that path
        if (node.left != null) {
            return node.data + left;
        }

        return node.data + right;
    }
}