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
    public ListNode[] splitListToParts(ListNode head, int k) {
     int length = 0;
        ListNode current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        current = head;
        int partSize = length / k;
        int rem = length % k;

        ListNode[] result = new ListNode[k];

        for(int i=0; i<k && current != null; i++){
            result[i] = current;
            int currentPartSize = partSize + ((i<rem) ? 1 : 0);
            for(int j=0; j<currentPartSize-1; j++){
                current = current.next;
            }

            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return result;   
    }
}
