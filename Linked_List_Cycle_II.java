//Time O(N) space O(1)
/*
  Assume the length is N
  If it is a cycle
  assume the distance from the begin cycle is F
  the distance from F to first time slow and fast meet is A
  the distance from A to cycle begin is B
  slow travel F + A
  fast travel F+A+B
  since fast travel twice faster then slow
  2(F+A) = F+A+B+A
  F+A+F+A = F+A+B+A
  F = B
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while(slow!= head){
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
