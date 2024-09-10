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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;

        if(size == 1) {
            return head;
        }
        if(size == 2) {
            int gcdVal = findGCD(temp.val, temp.next.val);
            ListNode newNode = new ListNode(gcdVal);
            ListNode prev = temp;
            temp = temp.next;
            prev.next = newNode;
            newNode.next = temp;
            return head;
        }
        for(int i=1; i<size-1; i++) {
            if(temp == null || temp.next == null) break;
            int gcdVal = findGCD(temp.val, temp.next.val);
            ListNode newNode = new ListNode(gcdVal);
            ListNode prev = temp;
            temp = temp.next;
            prev.next = newNode;
            newNode.next = temp;
            size++;
        }

        return head;
    }

    private int findGCD(int x, int y) {
        int ans = 1;
        for(int num = 2; num<= Math.min(x, y); num++) {
            if(x % num == 0 && y % num == 0) {
                ans = num;
            }
        }

        return ans;
    }
}
