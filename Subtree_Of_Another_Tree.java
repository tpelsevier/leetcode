//Time O(N) Space O(1)
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(isSame(s,t)) return true;
        return isSubtree(s.left,t)  || isSubtree(s.right,t);
    }
    private boolean isSame(TreeNode s,TreeNode t){
        if(s == null && t == null) return true; //If two of them are null return true
        if(s == null || t ==null) return false; //If only one of them is null return false;
        if(s.val != t.val)return false;
        return isSame(s.right,t.right) && isSame(s.left,t.left);
    }
}
