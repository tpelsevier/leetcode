//Time O(N) space O(1)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next; //find the head if the head is == val
        ListNode t = head;
        while(t != null && t.next != null){
            if(t.next.val == val){
                t.next = t.next.next;
                continue;
            }
            t = t.next;

        }
        return head;
    }
}
