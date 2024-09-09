/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
         int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        ListNode currentNode = head;
        
        while (top <= bottom && left <= right && currentNode != null) {
            for (int j = left; j <= right && currentNode != null; j++) {
                matrix[top][j] = currentNode.val;
                currentNode = currentNode.next;
            }
            top++;
            
            for (int i = top; i <= bottom && currentNode != null; i++) {
                matrix[i][right] = currentNode.val;
                currentNode = currentNode.next;
            }
            right--;
            
            for (int j = right; j >= left && currentNode != null; j--) {
                matrix[bottom][j] = currentNode.val;
                currentNode = currentNode.next;
            }
            bottom--;
            
            for (int i = bottom; i >= top && currentNode != null; i--) {
                matrix[i][left] = currentNode.val;
                currentNode = currentNode.next;
            }
            left++;
        }
        
        return matrix;
    }
}
