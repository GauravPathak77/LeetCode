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
    public int count = 0;
    public int average(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = average(root.left);
        int right = average(root.right);
        int ans = left+right+root.val;

        if(ans/countNodes(root) == root.val){
            count++;
        }
        return ans;
    }
    public int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
    public int averageOfSubtree(TreeNode root) {
        average(root);
        return count;
    }
}
