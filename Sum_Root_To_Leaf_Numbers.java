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
    public int sumNumbers(TreeNode root) {
        return path(root,0);
    }
    private int path(TreeNode root, int curr){
        if(root == null) return 0;
        curr = curr * 10 + root.val;
        if(root.left == null && root.right == null) return curr;
        return path(root.left,curr)+path(root.right,curr);
    }
}
