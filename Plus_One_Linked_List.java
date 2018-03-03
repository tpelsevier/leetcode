/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //Time O(N) Space O(1)
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy; //The last node that is not equals to 9
        ListNode j = dummy; //The travel node to the end
        while(j.next != null){
            j = j.next;
            if(j.val != 9) i = j;
        }
        i.val++;
        i = i.next;
        while(i != null){
            i.val = 0;
            i = i.next;
        }
        return dummy.val == 1? dummy:dummy.next;
    }
}
