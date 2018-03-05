//Time O(N) Space O(N)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        helper(root,new ArrayList<>(),sum,0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> ls,int sum,int curr){
        if(root.left == null && root.right == null){
            if(curr + root.val == sum) { //If curr equals sum
                ls.add(root.val); //add to the ls
                res.add(new ArrayList<>(ls)); //Then create a new list
                ls.remove(ls.size()-1); //Move it from the list for upper level to used to again
            }
            return;
        }
        ls.add(root.val);
        if(root.left != null) helper(root.left,ls,sum,curr+root.val);
        if(root.right != null) helper(root.right,ls,sum,curr+root.val);
        ls.remove(ls.size()-1);

    }

}
