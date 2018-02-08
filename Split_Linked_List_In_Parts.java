//Time O(N) Space O(N)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ns = new ListNode[k]; //Initialized the node
        if(root == null) return ns;
        int size = 1;
        ListNode dummy = root; //Travel node
        //Find the size of the LinkedList
        while(dummy.next != null){
            dummy = dummy.next;
            size++;
        }
        int np = size /k;
        int rem = size % k; //Remain of of the size divide by part and add to first rem parts of the List Node
        for(int i = 0;i<k;i++){
            if(dummy == root) break;
            ns[i] = root;
            int steps = (rem >0)? 1:0; //If remaining bigger than 0 add extra to it
            steps+=np;
            rem--; //The remaining should be reduced
            while(steps-->1) dummy = root.next;
            ListNode prev = root; //Store the last node of a part
            root = root.next; //New node in an array
            prev.next = null;// split
        }
        return ns;
    }
}
