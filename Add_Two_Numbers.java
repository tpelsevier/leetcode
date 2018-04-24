/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //Time O(M+N) Space O(1)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
    private ListNode addTwoNumbers(ListNode l1, ListNode l2,int extra){
        if(l1 == null && l2 == null){
            if(extra == 0) return null;
            else return new ListNode(1);
        }
        if(l1 == null){
            l2.val = l2.val + extra;
            return l2;
        }
        if(l2 == null){
            l1.val = l1.val + extra;
            return l1;
        }
        int val = l1.val + l2.val + extra;
        ListNode head = new ListNode(val%10);
        head.next = val >= 10? addTwoNumbers(l1.next,l2.next,1): addTwoNumbers(l1.next,l2.next,0);
        return head;

    }
}
