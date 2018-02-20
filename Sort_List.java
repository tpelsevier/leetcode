//Time: O(NlogN) Space O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head  == null || head.next == null) return head;
        ListNode fast = head, slow = head,prev = head;
        while(fast != null && fast.next != null){
            prev = slow; //Recording the prev of slow
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null; //Seperated two List
        ListNode l1 = sortList(head); //Divided
        ListNode l2 = sortList(slow); //Divided
        return merge(l1,l2); //Finally merge
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
