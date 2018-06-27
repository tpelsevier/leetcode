//Time O(N) Space O(N)
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int total = 0;
        for(char c: S.toCharArray()){
            if(c == '('){
                stack.push(-1);
            }else{
                int curr = 0;
                while(stack.peek() != -1){
                    curr += stack.pop();
                }
                stack.pop();
                stack.push(curr == 0? 1: curr * 2);
            }
        }
        while(!stack.isEmpty()) total +=stack.pop();
        return total;
    }
}
