//Time O(N) Space O(N)
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        if(root == null) return ls;
        helper("",root,ls);
        return ls;
    }
    private void helper(String curr,TreeNode node,List<String> ls){
        if(node.left == null && node.right == null){
            curr+=String.valueOf(node.val);
            ls.add(curr);
            return;
        }
        if(node.left != null) helper(curr+node.val+"->",node.left,ls);
        if(node.right != null) helper(curr+node.val+"->",node.right,ls);
    }
}
