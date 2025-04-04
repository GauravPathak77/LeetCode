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
    private boolean lcaUtil(TreeNode root, TreeNode k, List<TreeNode> path) {
        if(root == null) return false;

        path.add(root);
        if(root == k) return true;

        boolean left = lcaUtil(root.left, k, path);
        boolean right = lcaUtil(root.right, k, path);

        if(left || right) return true;

        path.remove(path.size() - 1);
        return false;  
    }
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        TreeNode ans = p;

        lcaUtil(root, p, path1);
        lcaUtil(root, q, path2);

        for(int i = 0; i < path1.size(); i++) {
            if(path1.get(i) == path2.get(i)) ans = path1.get(i);
            else break;
        }

        return ans;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return null;

        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            list = new ArrayList<>();
            int n = q.size();

            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                list.add(curr);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }

        if(list.size() == 1) return list.get(0);
        return lca(root, list.get(0), list.get(list.size() - 1));
    }
}
