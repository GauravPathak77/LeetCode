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
    int moves = 0;
    public int distributeCoins(TreeNode root) {
       distributeCoinsUtil(root);
       return moves;
    }

    public int distributeCoinsUtil(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = distributeCoinsUtil(root.left);
        int right = distributeCoinsUtil(root.right);

        moves += Math.abs(left) + Math.abs(right);
        return (left + right + root.val) - 1;
    }
}
