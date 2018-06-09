//Time O(NlogN) Space O(1)
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null;
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(slow);
        return merge(left,right);
    }
    private ListNode merge(ListNode left,ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if(left.val < right.val){
            left.next = merge(left.next,right);
            return left;
        }else{
            right.next = merge(left,right.next);
            return right;
        }

    }
}
