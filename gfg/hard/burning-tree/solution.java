import java.util.*;

class Solution {
    static Node targetNode;

    public static int minTime(Node root, int target) {
        targetNode = null;
        HashMap<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, null, target, parentMap);

        if (targetNode == null) return 0;

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnedAny = false;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                // Check Left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                    burnedAny = true;
                }
                // Check Right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                    burnedAny = true;
                }
                // Check Parent
                Node parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.add(parent);
                    burnedAny = true;
                }
            }
            if (burnedAny) time++;
        }
        return time;
    }

    static void buildParentMap(Node root, Node parent, int target, HashMap<Node, Node> parentMap) {
        if (root == null) return;
        parentMap.put(root, parent);
        if (root.data == target) targetNode = root;

        buildParentMap(root.left, root, target, parentMap);
        buildParentMap(root.right, root, target, parentMap);
    }
}