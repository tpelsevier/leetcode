//Time O(N) Space O(N); implpementing using java built-in stack
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return nums;
        int n = nums.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{nums[0],0});
        Arrays.fill(res,-1);
        //Since it needs to find circularly, so we run the array twice
        for(int i = 1;i < n * 2;i++){
            while(!stack.isEmpty() && stack.peek()[0] < nums[i%n]){
                int[] ele = stack.pop();
                res[ele[1]] = nums[i%n];
            }
            stack.push(new int[]{nums[i%n],i%n});
        }
        return res;
    }
}
//Time O(N) Space O(N) implementing stack using array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0 || nums == null) return nums;
        int n = nums.length;
        int[] res = new int[n];
        int[] stack = new int[n*2]; //Fill the array two times bigger incase NPE
        int top = -1;
        Arrays.fill(res,-1);
        for(int i = 0;i < n * 2;i++){
            while(top>-1 && nums[stack[top]] < nums[i%n]){
                res[stack[top--]] = nums[i%n];
            }
            stack[++top] = i%n;
        }
        return res;
    }
}
