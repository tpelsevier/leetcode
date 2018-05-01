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
    int res = 0;
    public int findTilt(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return 0;
        findSum(root);
        return res;
    }
    private int findSum(TreeNode root){
        if(root.left == null && root.right == null) return 0;
        int left = 0;
        int right = 0;
        if(root.left != null) left = root.left.val + findSum(root.left);
        if(root.right != null) right = root.right.val + findSum(root.right);
        res+= Math.abs(left-right);
        return left+right;
    }

}
