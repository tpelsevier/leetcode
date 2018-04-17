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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)  return 0;
        int left = findNode(root.left);
        int right = findNode(root.right);
        return Math.max(left+right,max);
    }
    private int findNode(TreeNode root){
        if(root == null) return 0;
        int left = findNode(root.left);
        int right = findNode(root.right);
        max = Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}
