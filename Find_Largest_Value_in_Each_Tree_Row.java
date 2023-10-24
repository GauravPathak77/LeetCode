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
        List<Integer> result = new ArrayList<>();
    
    if (root == null) {
        return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null); // Use null as a marker for the end of each level
    
    int rowMax = Integer.MIN_VALUE;

    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        
        if (current == null) {
            result.add(rowMax); // Finished processing the current level
            rowMax = Integer.MIN_VALUE;
            
            if (!queue.isEmpty()) {
                queue.offer(null); // Add marker for the next level
            }
        } else {
            rowMax = Math.max(rowMax, current.val);
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }
    
    return result;
    }
}
