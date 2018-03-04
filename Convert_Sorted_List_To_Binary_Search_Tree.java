//Time O(NLog(N)) SPACE O(1)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode fast = head;
        ListNode slow = head; //The mid val
        ListNode prev = head;// This node is for dividing list into hafl
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
