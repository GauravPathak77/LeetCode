/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        while(temp.next.next != null){
            temp.val = temp.next.val;
            temp = temp.next;
        }
        temp.val = temp.next.val;
        temp.next = null;
    }
}
