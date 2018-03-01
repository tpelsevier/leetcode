//Time O(N) Space O(N)
class Solution {
    HashMap<Integer, Integer> preSum = new HashMap();
    public int pathSum(TreeNode root, int sum) {
        preSum.put(0,1);//Put 0 there incase there is a root node value == 0
        return helper(root, 0, sum);
    }

    public int helper(TreeNode root, int currSum, int target) {
        if (root == null) {
            return 0;
        }

        currSum += root.val; //Sum totoal at this current node
        //See if current sum minus any of the pre existed sum value in the map equals to target sum
        int res = preSum.getOrDefault(currSum - target, 0);
        //add the frequency of current node to 1
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        //Continue counting the child node
        res += helper(root.left, currSum, target) + helper(root.right, currSum, target);
        //move curr sum incase of reused in the another child node of upper level
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
