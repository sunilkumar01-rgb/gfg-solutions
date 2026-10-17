class Solution {
    int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }
    
    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;
        
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);
        
        maxDiameter = Math.max(maxDiameter, left + right);
        
        return 1 + Math.max(left, right);
    }
}