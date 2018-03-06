//Time O(N) Space O(1)
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        if(height == null || height.length < 3) return sum;
        int l = 0, r = height.length-1;
        while(l<r && height[l] <=height[l+1]) l++; //Find the left edge
        while(l<r && height[r] <= height[r-1]) r--; //Find the right edge
        while(l < r){
            int left = height[l];
            int right = height[r];
            //since left is smaller than right, so it can keep going
            if(left < right) while(l <r && height[++l] < left) sum += left - height[l];
            else while(l<r && height[--r] < right) sum+= right - height[r];
        }
        return sum;

    }
}
