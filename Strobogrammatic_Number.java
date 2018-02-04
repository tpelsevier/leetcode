//Time O(N) space O(1)
class Solution {
    public boolean isStrobogrammatic(String num) {
        String sample = "00 11 88 696";
        int s = 0, e = num.length()-1;
        while(s<=e) {if(!sample.contains(num.charAt(s++)+""+num.charAt(e--))) return false;}
        return true;
    }
}
