// Time: O(N), Space: O(N)
// Since using stack;
class Solution {

    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(0); //Push to make it size 1
        for(String s:input.split("\n")){
            int level = s.lastIndexOf("\t")+1; //First one is size 1
            while(level +1 < stack.size()) stack.pop(); //Go back to the parent directory
            int len = stack.peek()+s.length()-level+1;  //Total length from root to parent plus length of current dir, plus one means the '/' between two level
            stack.push(len);
            if(s.contains(".")) max = Math.max(max,len-1); //File.exe contains "." which means that is the end
        }
        return max;
    }
}
