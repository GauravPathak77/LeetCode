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
    private void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leafNodes) {
        if(root == null) return;

        if(root.left == null && root.right == null) leafNodes.add(root);

        if(prev != null) {
            graph.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            graph.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }

        makeGraph(root.left, root, graph, leafNodes);
        makeGraph(root.right, root, graph, leafNodes);
    }
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> leafNodes = new HashSet<>();
        int count = 0;

        makeGraph(root, null, graph, leafNodes);

        for(TreeNode leaf : leafNodes) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.add(leaf);
            visited.add(leaf);

            for(int level=0; level<= distance; level++) {
                int size = queue.size();

                while(size-- > 0) {
                    TreeNode curr = queue.poll();

                    if(curr != leaf && leafNodes.contains(curr)) count++;

                    for(TreeNode neighbour : graph.getOrDefault(curr, new ArrayList<>())) {
                        if(!visited.contains(neighbour)) {
                            queue.add(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
            }
        }

        return count / 2;
    }
}
