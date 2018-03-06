/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time O(N) Space O(N)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> ls = new LinkedList<>();
        stack.push(root);
        while(root!=null && !stack.isEmpty()){
            root = stack.pop();
            ls.addFirst(root.val);// Adding reversely
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);

        }
        return ls;
    }
}
