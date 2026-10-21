class Solution {
    int maxDiameter = 0;

    public int diameter(Node root) {
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(Node node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // Update maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}