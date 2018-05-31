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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        findLargest(root,0,ans);
        return ans;
    }
    public void findLargest(TreeNode root,int level,List<Integer> ans){
        if(ans.size() <= level) ans.add(root.val);
        else ans.set(level,Math.max(root.val,ans.get(level)));
        if(root.left != null) findLargest(root.left,level+1,ans);
        if(root.right != null) findLargest(root.right,level+1,ans);
    }
}
