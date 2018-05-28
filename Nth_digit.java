//Time O(N) Space O(1)
class Solution {
    public int findNthDigit(int n) {
        if(n < 10) return n;
        n--;
        int first = 1, digit = 1;
        while(n / 9 / first / digit >= 1){
            n -= 9*first*digit;
            digit++;
            first*=10;
        }
        return (first+n/digit+"").charAt(n%digit)-'0';
    }
}
