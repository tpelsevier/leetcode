//Time O(1) Space O(1)

//Power of four contains only 1 bit
//But the binary string length is odd 
class Solution {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) ==1 && Integer.toBinaryString(num).length() %2 == 1;
    }
}
