//Time O(N*M) Space O(M)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m];
        int[] right = new int[m];
        int[] left = new int[m];
        Arrays.fill(right,m);
        int res = 0;
        for(int i = 0; i < n; i ++){
            int currLeft = 0, currRight = m;
            //Compute the height at current column
            for(int j = 0;j < m; j++){
                if(matrix[i][j] =='1')height[j] ++;
                else height[j] = 0;
            }
            //Compute the most left edge for index at point j if index j is equals to 1
            for(int j = 0; j <m;j++){
                if(matrix[i][j] == '1'){
                   left[j] = Math.max(currLeft,left[j]);
                }else{
                    left[j] = 0;
                    currLeft = j+1;
                }
            }
            //Compute the most right edge for index at point j if index j is equals to 1
            for(int j = m-1;j>=0;j--){
                if(matrix[i][j] == '1'){
                    right[j] = Math.min(currRight,right[j]);
                }else{
                    right[j] = m;
                    currRight = j;
                }
            }
            for(int j = 0; j < m;j++) res = Math.max(res,(right[j] - left[j]) * height[j]);
        }
        return res;
    }
}
//Time O(M*N) Space(N)

/*
1 0 0 0 0
1 1 0 1 1
1 1 1 1 1     Since col 0 to col 2 is all decreasing, so the height in index can directly times the index

0 0 1
0 1 1
1 1 1     Since col 0 to col 2 is all increasing, so we need extral height at end, to pop everything
          So j - stack.peek() - 1 means the distance from last index all the way to the first index located
          can used it's owned height to compute the area
*/
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix == null) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[] height = new int[m+1];
        int res = 0;
        for(int i = 0; i < n;i++){
        Stack<Integer> stack = new Stack<>();
            for(int j = 0; j < m+1;j++){
                if(j < m){
                    if(matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                }
                // if the height is increasing keep pushing
                if(stack.isEmpty() || height[j] >= height[stack.peek()]){
                    stack.push(j);
                }else{
                    //If the height is decreasing, we need to start poping, in order to find the max rec,
                    //Since all the previous heights are higher, so from point j to point i where i is lower than point j which is the highest point,
                    // The height can be apply to the same length
                    while(!stack.isEmpty() && height[stack.peek()] > height[j]){
                        int curr = height[stack.pop()] * (stack.isEmpty()?j:j-stack.peek()-1);
                        res = Math.max(curr,res);
                    }
                    stack.push(j);
                }

            }
        }
        return res;
    }
}
