class Solution {
    boolean search(Node root, int x) {
        while (root != null) {
            if (root.data == x) return true;
            else if (root.data > x) root = root.left;
            else root = root.right;
        }
        return false;
    }
}