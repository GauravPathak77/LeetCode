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
    public ListNode doubleIt(ListNode head) {
        head = reverseLL(head);
        int carry = 0;
        ListNode temp = head;
        ListNode prev = head;

        while(temp != null){
            int num = temp.val;
            num = (num * 2) + carry;
            carry = 0;
            prev = temp;

            if(num / 10 != 0){
                carry = num / 10;
                num = num % 10;
            }
            temp.val = num;
            temp = temp.next;
        }

        if(carry != 0){
            prev.next = new ListNode(carry);
        }

        head = reverseLL(head);
        return head;
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
