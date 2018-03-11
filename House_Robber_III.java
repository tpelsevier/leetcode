//Time (2^n) space O(N)
class Solution {
    public int rob(TreeNode root) {
        int [] res = robb(root);
        return Math.max(res[0],res[1]);
    }
    private int[] robb(TreeNode root){
        if(root == null) return new int[2];
        int[] left = robb(root.left);
        int[] right = robb(root.right);
        int[] res = new int[2];
        //Res[0] means does not include current node
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //Res[1] means include current node
        res[1] = left[0]+right[0]+ root.val;

        return res;
    }
}
