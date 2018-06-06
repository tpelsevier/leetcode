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
    boolean down = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = findLevel(root.left);
        int right = findLevel(root.right);

        return (!(Math.abs(left-right) > 1)) && down;
    }
    private int findLevel(TreeNode root){
        if(root == null) return 0;
        int left = findLevel(root.left);
        int right = findLevel(root.right);
        if(Math.abs(left-right) > 1) down = false;
        return Math.max(left,right)+1;
    }
}
