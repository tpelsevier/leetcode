//Time O(N) space O(N)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //Only store right
        while(root != null && !stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return res;
    }
}
