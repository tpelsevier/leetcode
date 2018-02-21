//Time O(N) Space O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val) curr = curr.next;
            if(prev.next == curr) prev = prev.next; //If curr is not duplicated continue
            else prev.next = curr.next; //If curr is duplicated prev.next will set to curr.next
            curr = curr.next;
        }
        return dummy.next;
    }
}
