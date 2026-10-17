class Solution {
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorderHelper(root, ans);
        return ans;
    }

    void preorderHelper(Node node, ArrayList<Integer> ans) {
        if (node == null) return;
        ans.add(node.data);
        preorderHelper(node.left, ans);
        preorderHelper(node.right, ans);
    }
}