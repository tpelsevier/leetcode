//Time O(N) space O(N)
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public boolean checkEqualTree(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return false;
        int sum = getSum(root);
        if(sum == 0) return map.getOrDefault(sum,0) > 1;// sum == 0 is a special case
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    private int getSum(TreeNode t){
        if(t == null) return 0;
        //Values current node have plus it's sub nodes
        int sum = t.val + getSum(t.right) + getSum(t.left);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}
