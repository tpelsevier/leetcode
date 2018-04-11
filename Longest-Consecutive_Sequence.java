//Time O(N) Space O(N)
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        for(int n: nums){
            if(!map.containsKey(n)){
                int l = map.getOrDefault(n-1,0);
                int r = map.getOrDefault(n+1,0);

                int sum = l + r + 1;
                map.put(n,sum);
                ans = Math.max(sum,ans);
                map.put(n-l,sum);
                map.put(n+r,sum);
            }
        }
        return ans;
    }
}

//Time O(NlogN) Space O(1)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int ans = 0, count = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i]-1 == nums[i-1]) count ++;
            else{
                ans = Math.max(count,ans);
                count = 1;
            }
        }
        return Math.max(ans,count);

    }
}
