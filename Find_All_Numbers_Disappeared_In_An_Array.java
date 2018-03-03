//Time O(N) space O(N)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        boolean[] t = new boolean[nums.length];
        for(int n: nums){
            t[n-1] = true;
        }
        for(int i = 0;i<nums.length;i++){
            if(!t[i])ls.add(i+1);
        }
        return ls;
    }
}
