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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inmap);
    }

    TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend,
        Map<Integer, Integer> inmap) {
            if(prestart>preend ||instart>inend) return null;
            TreeNode root = new TreeNode(preorder[prestart]);
            int rootIn = inmap.get(preorder[prestart]);

            root.left =build(preorder, prestart+1, prestart+rootIn-instart, 
                                inorder, instart, rootIn-1, inmap);
            root.right = build(preorder, prestart+rootIn-instart+1, preend, 
                                inorder, rootIn+1, inend, inmap);

            return root;



        }
}
