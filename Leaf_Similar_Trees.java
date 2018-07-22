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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        findLeaf(r1,root1);
        List<Integer> r2 = new ArrayList<>();
        findLeaf(r2,root2);
        if(r1.size() != r2.size()) return false;
        for(int i = 0; i < r1.size();i++){
            if(r1.get(i) != r2.get(i)) return false;
        }
        return true;
    }
    private void findLeaf(List<Integer> res, TreeNode root) {
        if(root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        if(root.left != null) findLeaf(res,root.left);
        if(root.right != null) findLeaf(res,root.right);
    }
    
}
