//BFS Time O(N) Space O(N)
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        return root.val;
    }
}
//DFS Time O(N) Space O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        return dfs(root,1,new int[]{0,0});
    }
    //Find the deepest one, and then return the node value
    private int dfs(TreeNode root, int level, int[] res){
        if(res[1] < level){res[0] = root.val; res[1] = level;}
        if(root.left != null) dfs(root.left,level+1,res);
        if(root.right != null) dfs(root.right,level+1,res);
        return res[0];
    }
}
