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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> nodeList = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                nodeList.add(curr);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(level % 2 != 0) {
                int left = 0, right = size - 1;
                while(left <= right) {
                    int temp = nodeList.get(left).val;
                    nodeList.get(left).val = nodeList.get(right).val;
                    nodeList.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}
