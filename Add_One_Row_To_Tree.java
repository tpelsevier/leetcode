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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        travel(root,v,d,1);
        return root;
    }
    private void travel(TreeNode root, int v, int d,int level){
        if(level+1 == d){
            TreeNode newLeft = new TreeNode(v);
            newLeft.left = root.left;
            root.left = newLeft;
            TreeNode newRight = new TreeNode(v);
            newRight.right = root.right;
            root.right = newRight;
            return;
        }
        if(root.left != null) travel(root.left,v,d,level+1);
        if(root.right != null) travel(root.right,v,d,level+1);
    }
}
