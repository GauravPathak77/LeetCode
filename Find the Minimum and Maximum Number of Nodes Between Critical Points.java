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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int[] ans = {-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;
        int idx = 2;

        while(curr.next != null){
            if((curr.val > prev.val && curr.val > curr.next.val) || (curr.val < prev.val && curr.val < curr.next.val)) {
                list.add(idx);
            }

            idx++;
            prev = prev.next;
            curr = curr.next;
        }

        if(idx > 2 && list.size() >= 2){
            int n = list.size();
            ans[0] = Integer.MAX_VALUE;
            for(int i=0; i<n-1; i++){
                ans[0] = Math.min(ans[0], list.get(i+1)-list.get(i));
            }
            
            ans[1] = list.get(n-1) - list.get(0);
        }

        return ans;
    }
}
