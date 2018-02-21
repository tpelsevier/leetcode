//Time O(N) Space O(N)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0],0});//Store tem and index
        for(int i = 1;i<temperatures.length;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                int [] t = stack.pop();
                res[t[1]] = i - t[1];
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return res;
    }
}
//Time O(N) space O(N)
//This method basically implpementing the stack using array instead of using Java build-in library 
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] stack = new int[temperatures.length];
        int [] res = new int[temperatures.length];
        int top = -1;
        for(int i = 0;i<temperatures.length;i++){
            while(top > -1 && temperatures[stack[top]] < temperatures[i]){
                res[stack[top]] = i - stack[top];
                top--;
            }
            stack[++top] = i;
        }
        return res;
    }
}
