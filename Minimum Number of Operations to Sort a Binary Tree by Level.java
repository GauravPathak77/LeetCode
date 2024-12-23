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
    public int minimumOperations(TreeNode root) {
        int ans = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                arr[i] = curr.val;
                map.put(curr.val, i);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            ans += solve(arr, map);
        }

        return ans;
    }

    private int solve(int[] arr, Map<Integer, Integer> map) {
        int n = arr.length;
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i] == sortedArr[i]) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = map.get(sortedArr[j]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}
