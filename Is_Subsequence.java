//Time O(N) Space O(1)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length()){
            int index = -1;
            if(j < t.length()) index = t.indexOf(s.charAt(i++),j);
            if(index == -1) return false;
            j = index +1;
        }
        return true;
    }
}
