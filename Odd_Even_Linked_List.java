//Time O(N) space O(1)
/*
  1->2->3->4->5
  Order is odd even odd even so on and forth
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head != null && head.next != null){
            ListNode odd = head, even = head.next,evenHead = even;
            while(even!=null && even.next != null){
                odd.next = even.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
