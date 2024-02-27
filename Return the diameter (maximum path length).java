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
    public class DiameterData {
        int diameter;
        int height;
        DiameterData(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public DiameterData calculateDiameterAndHeight(TreeNode root) {
        if (root == null) {
            return new DiameterData(0, 0);
        }

        DiameterData leftData = calculateDiameterAndHeight(root.left);
        DiameterData rightData = calculateDiameterAndHeight(root.right);

        int currentDiameter = Math.max(leftData.height + rightData.height, 
                                        Math.max(leftData.diameter, rightData.diameter));
        int currentHeight = Math.max(leftData.height, rightData.height) + 1;

        return new DiameterData(currentDiameter, currentHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        DiameterData data = calculateDiameterAndHeight(root);
        
        return data.diameter;
    }
}
