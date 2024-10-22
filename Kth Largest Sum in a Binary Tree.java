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
    private void levelOrderTraversal(TreeNode root, PriorityQueue<Long> pq, int k) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        pq.add((long)root.val);
        long sum = 0;

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    q.add(null);
                    break;
                } else q.add(null);
                sum = Math.max(sum, pq.poll());
                pq.add(sum);
                sum = 0;
            }
            else {
                if(curr.left != null) {
                    q.add(curr.left);
                    sum += curr.left.val;
                }
                if(curr.right != null) {
                    q.add(curr.right);
                    sum += curr.right.val;
                }
            }
        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0; i<k-1; i++) pq.add((long)-1);
        levelOrderTraversal(root, pq, k);
        return pq.poll();
    }
}
