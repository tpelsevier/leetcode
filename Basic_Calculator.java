//Time O(N) Space O(N)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while(i < s.length()-1 && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                res += num * sign;
            }
            else if (s.charAt(i) == '+') sign = 1; //Change the sign to positive
            else if(s.charAt(i) == '-') sign = -1; // Change the sign to negative
            else if(s.charAt(i) == '('){
                stack.push(res); //Push the sign to the stack
                stack.push(sign); //Push the current result to the stack
                sign = 1; //Make the sign positive
                res = 0; //Make the result equals to 0
            }
            else if(s.charAt(i) == ')'){
               res = res* stack.pop() + stack.pop();  //Check the sign from the outside parenthese
            }
        }
        return res;
    }
}
