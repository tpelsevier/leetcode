//Time O(N) space O(N)
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        return 0;
    }
}

//Time O(N) space O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n,fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
