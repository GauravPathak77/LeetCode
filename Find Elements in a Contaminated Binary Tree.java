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
class FindElements {
    Set<Integer> st;
    public FindElements(TreeNode root) {
        st = new HashSet<>();
        root.val = 0;
        st.add(root.val);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                st.add(curr.val);
                if(curr.left != null) {
                    curr.left.val = 2*curr.val + 1;
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    curr.right.val = 2*curr.val + 2;
                    q.add(curr.right);
                }
            }
        }
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
