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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int res = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

                res = Math.max(res, curr.val);
            }

            ans.add(res);
        }

        return ans;
    }
}
