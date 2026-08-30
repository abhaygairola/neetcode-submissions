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
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    boolean isValid(TreeNode root, int leftl, int rightl) {
        if (root == null)
            return true;
        if (root.val <= leftl || root.val >= rightl) return false;
        else {
            return isValid(root.left, leftl, Math.min(rightl,root.val)) && isValid(root.right, Math.max(leftl,root.val), rightl);
        }
    }
}
