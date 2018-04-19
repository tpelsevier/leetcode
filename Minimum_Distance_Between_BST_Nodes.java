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
    int min = Integer.MAX_VALUE;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        prev = null;
        helper(root);
        return min;
    }
    private void helper(TreeNode root){
        if(root.left != null) helper(root.left);
        if(prev != null) min = Math.min(root.val - prev.val,min);
        prev = root;
        if(root.right!= null) helper(root.right);

    }
}
