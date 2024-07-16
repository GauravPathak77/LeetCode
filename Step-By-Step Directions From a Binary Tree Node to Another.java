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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> pathToStart = new ArrayList<>();
        List<Character> pathToDest = new ArrayList<>();
        
        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);
        
        int i = 0;
        while (i < pathToStart.size() && i < pathToDest.size() && pathToStart.get(i) == pathToDest.get(i)) {
            i++;
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int j = i; j < pathToStart.size(); j++) {
            result.append('U');
        }
        
        for (int j = i; j < pathToDest.size(); j++) {
            result.append(pathToDest.get(j));
        }
        
        return result.toString();
    }
    
    private boolean findPath(TreeNode root, int target, List<Character> path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        
        path.add('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        
        path.add('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        
        return false;
    }
}
