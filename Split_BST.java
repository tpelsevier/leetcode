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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(V == 0 ||  root == null || root.val == V) return new TreeNode[] {root};
        TreeNode t = root;
        TreeNode[] res = new TreeNode[2];
        res[0] = root;
        while(t!=null){
            if(t.left != null && t.left.val == V){
                res[1] = t.left;
                t.left = t.left.right; //All node bigger than Node(V) is add to the first node directly
                res[1].right = null; //Get rid of right child
                return res;
            }else if (t.right != null && t.right.val == V){
                res[1] = t.right.right;  //Every Node bigger than Node(V) is added to the array
                t.right.right = null; //get rid of right of right
                return res;
            }else{
               t = t.val <V?t.right:t.left;
            }
        }
        return res;
    }
}
