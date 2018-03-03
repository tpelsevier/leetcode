// Time O(N) space O(N)

//case 1000   1001
//case2 1099  1100
//case3 9999 10000
class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length-1;i >= 0;i--){
            if(digits[i] < 9){
                digits[i] ++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
