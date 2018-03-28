/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    int size = 0;
    Random rnd;
    public Solution(ListNode head) {
        this.head = head;
        ListNode t = head;
        while( t!= null){
            size++;
            t = t.next;//Get the size
        }
        rnd = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int i = rnd.nextInt(size);
        ListNode ran = head;
        while(i>0){
            ran = ran.next;
            i--;
        }
        return ran.val;
    }
}

/**
