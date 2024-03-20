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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = list1, temp1 = list1, curr = list1;
        a--; // Adjust a to match zero-based indexing
        
        // Traverse list1 to find the node at position (a-1)
        while (temp1 != null && a-- > 0) {
            temp1 = temp1.next;
            prev = temp1;
        }
        
        temp1 = list1; // Reset temp1 to traverse list1 again
        
        // Traverse list1 to find the node at position (b+1)
        while (temp1 != null && b-- > 0) {
            temp1 = temp1.next;
            curr = temp1;
        }
        
        ListNode temp2 = list2; // Initialize pointer to traverse list2
        
        // Traverse list2 to find the last node
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        
        prev.next = list2; // Connect the node before position 'a' to the head of list2
        temp2.next = curr.next; // Connect the last node of list2 to the node after position 'b'
        
        return list1; // Return the head of list1
    }
}
