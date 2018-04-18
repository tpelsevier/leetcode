//Time O(N) Space O(1)
class Solution {
    public boolean detectCapitalUse(String word) {
        int capCount = 0, nonCap = 0;
        char f = word.charAt(0);
        for(char c: word.toCharArray()){
            if((int)c > 64 &&(int)c < 91)capCount ++;
            if((int)c > 96 &&(int)c < 123) nonCap ++;
            if(!Character.isUpperCase(f) && capCount > 0) return false;
            if(capCount > 1 && nonCap > 0) return false;
        }
        return true;
    }
}
