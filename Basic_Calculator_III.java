//Time O(N) Space O(N)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        char[] cs = s.toCharArray();
        for(int i = 0; i < n;i++){
            char curr = cs[i];
            if(Character.isDigit(curr)){
                num = num*10+Character.getNumericValue(cs[i]);
            }
            else if(cs[i] == '('){
                int count = 1, j = i +1;
                for(;j < n;j++){
                    //find the location of the parenthese belong to current open parenthese
                    if(cs[j] == '(') count++;
                    if(cs[j] == ')') count--;
                    if(count == 0) break;
                }
                num = calculate(s.substring(i+1,j));
                i = j;
            }
            if(curr == '+' || curr == '-' || curr == '*' || curr == '/' || i == n - 1){
                //Excuting previous sign
                //If the i is the last element opearation needs to be applied
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop()/num);
                }
                num = 0;
                sign = curr;
            }
        }

        int total = 0;
        while(!stack.isEmpty()){
            total += stack.pop();
        }
        return total;
    }
}
