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
    Set<Integer> set = new HashSet<>();;
    public boolean findTarget(TreeNode root, int k) {
        if(root == null ) return false;
        if(set.contains(root.val)) return true;
        set.add(k-root.val);
        if(root.left == null && root.right == null) return false;
        return findTarget(root.left,k) || findTarget(root.right,k);
    }
}
