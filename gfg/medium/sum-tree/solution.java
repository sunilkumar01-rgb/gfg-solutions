class Solution {
    boolean isSumTree(Node root) {
        return checkSumTree(root) != -1;
    }

    int checkSumTree(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;

        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);

        if (leftSum == -1 || rightSum == -1 || node.data != leftSum + rightSum) {
            return -1;
        }

        return node.data + leftSum + rightSum;
    }
}