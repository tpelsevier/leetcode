/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time O(N) Space O(1)
class Solution {
    int min = Integer.MAX_VALUE, pre = -1; //Pre is used to store previous value
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != -1) min = Math.min(min,root.val-pre);
        pre = root.val;
        inorder(root.right);
    }
}
