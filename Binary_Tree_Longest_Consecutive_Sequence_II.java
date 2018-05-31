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
    public int longestConsecutive(TreeNode root) {
        findMax(root);
        return max;
    }
    private int[] findMax(TreeNode root){
        if(root == null) return new int[] {0,0};
        int des = 1, inc = 1;
        if(root.left != null){
            int[] left = findMax(root.left);
            if(root.val - root.left.val == 1){
                des = left[1] +1;
            } else if(root.val - root.left.val == -1){
                inc = left[0]+1;
            }
        }
        if(root.right != null){
            int[] right = findMax(root.right);
            if(root.val - root.right.val == 1){
                des = Math.max(des,right[1]+1);
            }else if(root.val - root.right.val == -1){
                inc = Math.max(inc,right[0]+1);
            }
        }
        max = Math.max(max,des+inc-1);
        return new int[]{inc,des};
    }
}
