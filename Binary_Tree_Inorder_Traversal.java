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
    public List<Integer> inorderTraversal(TreeNode root) {
      //Idea: Find smallest value from current node
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){ //Keep traveling left and push the root to the stack
                stack.push(root);
                root = root.left;
            }
            root = stack.pop(); //Stack pop the lease small value
            res.add(root.val);
            root = root.right; //Then traveling from the right node
        }
        return res;
    }
}
