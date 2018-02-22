//Time O(N) space O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q); //Find left
        TreeNode right = lowestCommonAncestor(root.right,p,q); //Find right
        //If both of left and right are null return root node
        return left ==null? right: right == null?left:root;
    }
}
