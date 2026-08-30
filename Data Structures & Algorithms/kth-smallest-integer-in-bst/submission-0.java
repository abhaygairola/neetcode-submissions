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
    int cnt;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        cnt = 0;
        res=-1;
        dfs(root,k);
        return res;
    }
    void dfs(TreeNode root,int k) {
        if (root == null)
            return;

        dfs(root.left,k);
        cnt++;
        if(cnt==k) {res = root.val;return;}
        dfs(root.right,k);
    }
}
