/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        TreeNode empty = new TreeNode();
        Deque<TreeNode> q = new ArrayDeque<>();
        List<String> val = new ArrayList<>();
        if (root == null)
            root = empty;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.pop();
            if (temp == empty) {
                val.add("#");
            } else {
                val.add(temp.val + "");
                if (temp.left == null) {
                    q.add(empty);
                } else {
                    q.add(temp.left);
                }
                if (temp.right == null) {
                    q.add(empty);
                } else {
                    q.add(temp.right);
                }
            }
        }
        return String.join(",", val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        int n = val.length;
        int cnt = 1;
        if ("#".equals(val[0]))
            return null;
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            String left = val[cnt++];
            String right = val[cnt++];
            TreeNode l = "#".equals(left) ? null : new TreeNode(Integer.parseInt(left));
            TreeNode r = "#".equals(right) ? null : new TreeNode(Integer.parseInt(right));
            cur.left = l;
            cur.right = r;
            if (l != null)
                q.add(l);
            if (r != null)
                q.add(r);
        }
        return root;
    }
}
