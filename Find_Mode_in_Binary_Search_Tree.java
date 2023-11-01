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
    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    private int[] modes;
    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        modes = new int[modeCount];
        modeCount = 0;
        currentCount = 0;
        inOrderTraversal(root);
        return modes;
    }
    private void inOrderTraversal(TreeNode node) {
        if (node == null) 
        return;

        inOrderTraversal(node.left);

        handleValue(node.val);

        inOrderTraversal(node.right);
    }

    private void handleValue(int val) {
        if (val == currentVal) {
            currentCount++;
        } else {
            currentVal = val;
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modeCount = 1;
        } else if (currentCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = currentVal;
            }
            modeCount++;
        }
    }
}
