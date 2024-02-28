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
    public int findBottomLeftValue(TreeNode root) {
        int ans = -1;
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        q.add(root);
        q.add(null);
        list.add(root);
        list.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                    list.add(null);
                }
            }

            else{
                if(curr.left != null){
                q.add(curr.left);
                list.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
                list.add(curr.right);
            }
            }
        }

        if(list.size() == 2){
            return list.get(0).val;
        }

        list.remove(list.size()-1);
        for(int idx=list.size()-1; list.get(idx) != null; idx--){
            if(list.get(idx-1) == null){
                ans = list.get(idx).val;
                break;
            }
        }
        return ans;
    }
}
