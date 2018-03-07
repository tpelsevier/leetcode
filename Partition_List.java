//Time O(N) Space O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(0);
        ListNode bigDummy = new ListNode(0);

        ListNode smallT = smallDummy;
        ListNode bigT = bigDummy;

        while(head != null){
            if(head.val < x){
                smallT.next = head;
                smallT = smallT.next;
            }else{
                bigT.next = head;
                bigT = bigT.next;
            }

            head = head.next;
        }

        smallT.next = bigDummy.next;
        bigT.next = null; //Set the next element of bigDummy tail to null 
        return smallDummy.next;
    }
}
