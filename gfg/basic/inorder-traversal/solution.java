class Solution {
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorderHelper(root, ans);
        return ans;
    }

    void inorderHelper(Node node, ArrayList<Integer> ans) {
        if (node == null) return;
        inorderHelper(node.left, ans);
        ans.add(node.data);
        inorderHelper(node.right, ans);
    }
}