public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("null,");
            } else {
                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        for (int i = 1; i < arr.length; i++) {
            TreeNode curr = q.poll();
            if (!arr[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.left);
            }
            if (!arr[++i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(curr.right);
            }
        }
        return root;
    }
}