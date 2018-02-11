// Time O(N) space O(1)
class Solution {
    int sum = 0; //Sum for current stage
    public TreeNode convertBST(TreeNode root) {
        sum(root);
        return root;
    }
    private void sum(TreeNode root){
        if(root == null) return;
        sum(root.right);//All the way to the right is the 0
        root.val += sum; //Until it gets to the most right node
        sum = root.val; //every nodes needs to plus that node
        sum(root.left);//Then went left
    }
}
