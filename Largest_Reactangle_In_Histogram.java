//Time O(N) Space O(N)
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0;i<=heights.length;i++){
            int h = i == heights.length?0:heights[i];
            //Current height needs to be larger than previous height in order to be
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int start = stack.isEmpty()? -1:stack.peek();
                int area = height*(i-start-1);// Since previous height index is being pop, so we put a start point to position backward
                max = Math.max(max,area);
            }
            stack.push(i);// The reason storing index because to get the width
        }
        return max;
    }
}
