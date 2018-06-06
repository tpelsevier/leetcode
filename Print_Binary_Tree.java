/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Time O(H*2^H) Space O(N)
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int len = (1 << height) -1;
        List<List<String>> res = new ArrayList<>();
        if(len < 0) return res;
        for(int i = 1; i < height+1; i++){
            String[] currLevel = new String[len];
            Arrays.fill(currLevel,"");
            level(currLevel, root, i,0,len);
            res.add(Arrays.asList(currLevel));
        }
        return res;
    }
    private void level(String[] currLevel, TreeNode root, int level, int start, int end){
        if(root == null) return;
        if(level == 1){
            currLevel[(start+end)/2] = String.valueOf(root.val);
        }
        int mid = (start+end)/2;
        level(currLevel,root.left,level-1,start,mid-1);
        level(currLevel,root.right,level-1,mid+1,end);
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}
