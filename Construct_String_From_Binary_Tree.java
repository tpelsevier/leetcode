//Time O(N) Space O(N);
class Solution {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String curr = ""+t.val;

        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if(left.isEmpty() && right.isEmpty()) return curr;
        //left is empty, so we need to reserve a empty block for it
        if(left.isEmpty()) return curr+"()"+"("+right+")";
        //if right is empty , we don't need to reserve a empty block for it
        if(right.isEmpty()) return curr+"("+left+")";
        return curr+"("+left+")"+"("+right+")";

    }
}
