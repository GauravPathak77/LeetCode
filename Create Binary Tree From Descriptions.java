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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> st = new HashSet<>();
        TreeNode root = null;

        for(int[] ele : descriptions) {
            int parent = ele[0];
            int child = ele[1];
            int isLeft = ele[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            st.add(child);

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if(isLeft == 1) {
                parentNode.left = childNode; 
            } else {
                parentNode.right = childNode;
            }
        }

        for(Integer key : map.keySet()) {
            if(!st.contains(key)) {
                root = map.get(key);
            }
        }

        return root;   
    }
}
