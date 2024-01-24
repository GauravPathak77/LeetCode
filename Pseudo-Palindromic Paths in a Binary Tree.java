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
    public int pseudoPalindromicPaths(TreeNode root) {
        return countPseudoPalindromes(root, 0);
    }

    private int countPseudoPalindromes(TreeNode node, int bitmask) {
        if (node == null) {
            return 0;
        }
        
        bitmask ^= 1 << node.val;

        if (node.left == null && node.right == null) {
            return (bitmask & (bitmask - 1)) == 0 ? 1 : 0;
        }

        int leftPaths = countPseudoPalindromes(node.left, bitmask);
        int rightPaths = countPseudoPalindromes(node.right, bitmask);

        return leftPaths + rightPaths;
    }
}
