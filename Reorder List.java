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
    ListNode reverselist(ListNode list){
        ListNode curr = null;
        while(list!=null){
            ListNode temp = list;
            list = list.next;
            temp.next = curr;
            curr = temp;
        }
        return curr;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        mid = reverselist(mid);

        while(mid!=null){
            ListNode node1 = head.next;
            ListNode node2 = mid.next;

            head.next = mid;
            mid.next = node1;
            head = node1;
            mid=node2;
        }

    }
}
