/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //Time O(N) space O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < m-1;i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode end = pre.next.next;

        for(int i = 0; i<n-m;i++){
            start.next = end.next; //Start.next keeps tracks of next step
            end.next = pre.next; //The end point .next equasl to pre.next
            pre.next = end; //Pre.next = current end;
            end = start.next; //current end equals to start.next which has been track by start.
        }
        return dummy.next;
    }
}
