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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while (!dq.isEmpty()) {
            TreeNode temp=root;
            int n = dq.size();
            for (int i = 0; i < n; i++) {
                temp = dq.poll();
                if(temp.left!=null)dq.add(temp.left);
                if(temp.right!=null)dq.add(temp.right);
            }
            res.add(temp.val);
        }
        return res;
    }
}
