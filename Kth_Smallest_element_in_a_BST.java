// time O(K) space O(1)
class Solution {
    int res = 0,index = 0;
    public int kthSmallest(TreeNode root, int k) {
        index = k; //Set the k == index
        helper(root,k);
        return res;
    }
    private void helper(TreeNode root,int k){
        if(root == null) return;
        helper(root.left,k);
        index--;// index --;
        if(index == 0){
          //if index = 0 set the res to the root val
            res = root.val;
            return;
        }
        helper(root.right,k);
    }
}
