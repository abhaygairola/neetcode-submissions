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
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }
    void dfs(TreeNode root, int size) {
        if (root == null)
            return;
        if (res.size() == size)
            res.add(root.val);
        dfs(root.right,size+1);
        dfs(root.left,size+1);
    }
}
