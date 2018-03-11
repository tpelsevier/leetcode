//Time O(N) Space O(N)
class Solution {
    Stack<TreeNode> stack = new Stack<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        preorder(root);
        root = stack.pop();
        while(!stack.isEmpty()){
            root.left = null;
            root.right = stack.pop();
            root = root.right;
        }
    }
    private void preorder(TreeNode root){
        if(root.right!=null) preorder(root.right);
        if(root.left != null) preorder(root.left);
        stack.push(root);
    }

}
//Time O(N) Space O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev; //Root.right equals to prev
        root.left = null; //Get rid of root.left
        prev = root; //Store current node in the prev
    }

}
