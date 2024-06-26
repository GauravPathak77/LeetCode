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
    public TreeNode balanceBST(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        inOrderTrav(root, inorder);
        return createBalanceBST(inorder, 0, inorder.size() - 1);
    }

    private void inOrderTrav(TreeNode root, List<Integer> inorder) {
        if(root == null) return;
        inOrderTrav(root.left, inorder);
        inorder.add(root.val);
        inOrderTrav(root.right, inorder);
    }

    private TreeNode createBalanceBST(
        List<Integer> inorder,
        int start,
        int end
    ) {
        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode leftSubtree = createBalanceBST(inorder, start, mid-1);
        TreeNode rightSubtree = createBalanceBST(inorder, mid+1, end);

        TreeNode node = new TreeNode(
            inorder.get(mid),
            leftSubtree,
            rightSubtree
        );
        
        return node;
    }
}
