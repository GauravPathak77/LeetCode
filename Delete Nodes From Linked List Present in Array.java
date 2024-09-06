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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);

        ListNode head2 = new ListNode();
        ListNode temp = head;
        ListNode temp2 = head2;

        while(temp != null) {
            if(!st.contains(temp.val)) {
                ListNode newNode = new ListNode(temp.val);
                temp2.next = newNode;
                temp2 = temp2.next;
            }
                temp = temp.next;
        }

        return head2.next;
    }
}
