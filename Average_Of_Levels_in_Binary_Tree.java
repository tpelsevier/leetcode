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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null) return res;
        List<double[]> ls = new ArrayList<>();
        bfs(root,0,ls);
        for(double[] val: ls){
            res.add(val[1]/val[0]);
        }
        return res;
    }
    private void bfs(TreeNode root, int level, List<double[]> ls){
        if(ls.size()<=level) ls.add(new double[2]);
        double[] res = ls.get(level);
        res[0]++;
        res[1] += root.val;
        if(root.left != null) bfs(root.left,level+1,ls);
        if(root.right != null) bfs(root.right,level+1,ls);
    }
}
