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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            return head.next;
        }
        temp = head; 
        while(temp != null){
            if(size-1 == n){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            size--;
        }
        return head;
    }
}
