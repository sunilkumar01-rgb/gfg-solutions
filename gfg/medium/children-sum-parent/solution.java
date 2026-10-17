class Solution {
    public static boolean isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int sum = 0;
        if (root.left != null) sum += root.left.data;
        if (root.right != null) sum += root.right.data;

        if (root.data == sum && 
            isSumProperty(root.left) && 
            isSumProperty(root.right)) {
            return true;
        }

        return false;
    }
}