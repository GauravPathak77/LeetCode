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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            List<TreeNode> nodesAtCurrentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                nodesAtCurrentLevel.add(currentNode);

                if (currentNode.left != null) {
                    levelSum += currentNode.left.val;
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelSum += currentNode.right.val;
                    queue.offer(currentNode.right);
                }
            }

            for (TreeNode node : nodesAtCurrentLevel) {
                int siblingSum = 0;

                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                if (node.left != null) {
                    node.left.val = levelSum - siblingSum;
                }

                if (node.right != null) {
                    node.right.val = levelSum - siblingSum;
                }
            }
        }

        return root;
    }
}
