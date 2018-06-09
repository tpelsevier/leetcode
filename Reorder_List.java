//Time O(N) Space O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; //Get Rid of Link
        slow = curr;
        //Reverse
        while(curr != null){
            slow = slow.next;
            curr.next = prev;
            prev = curr;
            curr = slow;
        }
        curr = prev;
        while(prev != null){
            curr = curr.next;
            prev.next = head.next;
            head.next = prev;
            head = prev.next;
            prev = curr;
        }
    }
}
