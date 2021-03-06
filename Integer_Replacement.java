//Goal is to remove as much 1 as possible
class Solution {
    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        int count = 0;
        while( n != 1) {
            if((n & 1) == 0){
                n >>>= 1;
            }else if(n == 3 || Integer.bitCount(n+1) > Integer.bitCount(n-1)){
                n--;
            }else n++;
            count++;
        }
        return count;
    }
}
