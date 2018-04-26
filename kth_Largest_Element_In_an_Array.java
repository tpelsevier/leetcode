//Time O(N log N) Spce O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length-1,index = nums.length-k;
        while(start < end){
            int pivot = partition(start,end,nums);
            if(pivot < index){
                start = pivot + 1;
            }else if(pivot > index){
                end = pivot - 1;
            }else{
                return nums[pivot];
            }
        }
        return nums[start];
    }
    private int partition(int start,int end, int[] nums){
        int pivoit = start;
        while(start <= end){
            while(start <= end && nums[start] <= nums[pivoit]) start ++;
            while(start <= end && nums[end] > nums[pivoit]) end--;
            if(start > end) break;
            swap(start,end,nums);
        }
        swap(pivoit,end,nums);
        return end;
    }
    private void swap(int s, int e, int[] nums){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}
