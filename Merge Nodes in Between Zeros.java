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
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = new ListNode();
        ListNode temp = head;
        ListNode newtemp = newList;
        temp = temp.next;
        int sum = 0;

        while(temp != null){
            if(temp.val == 0){
                newtemp.next = new ListNode(sum, null);
                newtemp = newtemp.next;
                sum = 0;
            } else {
                sum += temp.val;
            }
            temp = temp.next;
        }

        return newList.next;
    }
}
