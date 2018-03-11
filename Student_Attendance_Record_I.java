//Time O(N) Space O(1)
class Solution {
    public boolean checkRecord(String s) {
        if(s.indexOf("LLL") >= 0) return false;
        int count = 0;
        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i) == 'A') count++;
            if(count > 1) return false;
        }
        return true;
    }
}
//Time O(N) Space O(1)
class Solution {
    public boolean checkRecord(String s) {
        return s.indexOf("A") != s.lastIndexOf("A") || s.indexOf("LLL") >= 0?false:true;
    }
}
