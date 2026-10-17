class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root != null) dfs(root, "", ans);
        return ans;
    }
    
    private void dfs(TreeNode node, String path, List<String> ans) {
        if (node.left == null && node.right == null) {
            ans.add(path + node.val);
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", ans);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", ans);
        }
    }
}
