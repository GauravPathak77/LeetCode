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
    int sum = 0;

    private void bstToGstUtil(TreeNode node) {
        if (node == null){
            return;
        }

        bstToGstUtil(node.right);
        sum += node.val;
        node.val = sum;
        bstToGstUtil(node.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGstUtil(root);
        return root;
    }
}
