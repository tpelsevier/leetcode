//Time O(N) Space O(1)
class Solution {
    public String solveEquation(String equation) {
        if(equation.length() == 0 || equation == null) return "";
        int numberX = 0, number = 0, sign = 1,temp = 0,beforeEqual = 1,beforeEqualN = -1;
        boolean calculate = false;
        for(char c: equation.toCharArray()){
            if(c == '=') {
                number += sign *beforeEqualN* temp;
                temp = 0;
                sign = 1;
                beforeEqual = -beforeEqual;
                beforeEqualN = -beforeEqualN;
            }
            if(c == '-' || c == '+' ){
                number += beforeEqualN * sign * temp;
                temp = 0;
                sign = c == '-'? -1:1;
            }
            if(Character.isDigit(c)) {
                temp = temp * 10 + Character.getNumericValue(c);
                calculate = true;
                continue;
            }
            if(c == 'x'){
                temp = temp == 0?calculate?0:1:temp;
                numberX += beforeEqual * sign*temp;
                temp = 0;
            }
            calculate = false;
        }
        number += temp * sign*beforeEqualN;
        if(numberX == 0 && number == 0) return "Infinite solutions";
        if(numberX == 0 ) return "No solution";
        return "x="+ number / numberX;
    }
}
