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
    int min = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        find(root);
        return second == Integer.MAX_VALUE? -1:second;
    }
    private void find(TreeNode root){
        if(root.val < min){
            second = min;
            min = root.val;
        }else if (root.val != min && root.val < second) second = root.val;
        if(root.left != null) find(root.left);
        if(root.right != null) find(root.right);
    }
}
