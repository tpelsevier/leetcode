//Time O(N) Space O(N)
class Solution {
    LinkedList<Integer> res = new LinkedList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        helper(root,target,k);
        return res;
    }
    private void helper(TreeNode root, double target, int k){
        if(root.left != null) helper(root.left,target,k);
        if(res.size () == k){
            if(Math.abs(res.peekFirst()-target) > Math.abs(root.val - target)) res.removeFirst();
            else return;
        }
        res.add(root.val);
        if(root.right != null) helper(root.right,target,k);
    }
}
