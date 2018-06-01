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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        travel(root,res,0);
        Collections.reverse(res);
        return res;
    }
    private void travel(TreeNode root, List<List<Integer>> res,int level){
        if(res.size()<= level) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        if(root.left != null) travel(root.left,res,level+1);
        if(root.right != null) travel(root.right, res,level+1);
    }
}
