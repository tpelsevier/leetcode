//Time O(N) Space O(1)
class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() < 2) return 0;
        //Prev stores the amount for previous group
        //Curr stores the amount for current group
        int curr = 1, prev = 0, res = 0;
        for(int i = 1; i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)) curr++;
            else{
                res += Math.min(prev,curr);
                prev = curr;
                curr = 1;
            }
        }
        return res + Math.min(prev,curr);
    }
}
