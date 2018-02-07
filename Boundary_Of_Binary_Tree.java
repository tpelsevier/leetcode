/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time O(lgn) Space O(1)
class Solution {
    List<Integer> ls = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return ls;
        ls.add(root.val);
        leftB(root.left);
        leaves(root.left);
        leaves(root.right);
        rightB(root.right);
        return ls;
    }
    private void leftB(TreeNode root){
      //The reason why rooot.left and root.right == null return is that it will be handled by leaves method
        if(root == null || (root.left == null && root.right == null)) return;
        ls.add(root.val);
        if(root.left == null) leftB(root.right);
        else leftB(root.left);

    }
    public void rightB(TreeNode root){
        if(root ==null || (root.left == null && root.right == null)) return;
        if(root.right == null) rightB(root.left);
        else rightB(root.right);
        ls.add(root.val);

    }
    private void leaves(TreeNode root){
        if(root == null) return;
        if(root.left== null && root.right == null) {
            ls.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);

    }
}
