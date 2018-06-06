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
    int ans = Integer.MIN_VALUE;
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        dfs(map,root,0,0);
        return ans;

    }
    private void dfs(Map<Integer,Integer> map, TreeNode root, int level, int pos){
        map.computeIfAbsent(level,x -> pos);
        ans = Math.max(ans,pos - map.get(level)+ 1);
        if(root.left != null) dfs(map,root.left,level+1,pos*2);
        if(root.right!= null) dfs(map,root.right,level+1,pos*2+1);
    }
}
