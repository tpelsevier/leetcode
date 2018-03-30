
//Time O(N * (N-K+1)) Space O(1)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return nums;
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i = 0;i < n-k+1;i++){
            int max = nums[i];
            for(int j = i+1;j<i+k;j++){
                max = Math.max(max,nums[j]);
            }
            res[i] =max;
        }
        return res;
    }
}
//Time O(N) Space O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return nums;
        int n = nums.length;
        int [] res = new int[n-k+1];
        int ri = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        //Store index
        for(int i = 0; i < n;i++){
            //remove the numbers out range K
            while(!dq.isEmpty() && dq.peek() < i-k+1) dq.poll();
            //compare the current number to the previous number, if it is bigger than the previous one,remove
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offer(i);
            //Since there will be one element added after index K
            if(i >= k-1) res[ri++] = nums[dq.peek()];
        }
        return res;
    }
}
