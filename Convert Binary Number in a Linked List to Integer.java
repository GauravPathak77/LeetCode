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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int size = 0;

        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int ans = 0;
        temp = head;
        for(int i = size - 1; i >= 0; i--) {
            ans += temp.val * Math.pow(2, i);
            temp = temp.next;
        }

        return ans;
    }
}
