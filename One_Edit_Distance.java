//Time O(N) Space O(1)
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int diff = Math.abs(m-n);
        if(diff >= 2 || s.equals(t)) return false;
        for(int i = 0; i < Math.min(m,n);i++){
            if(s.charAt(i) != t.charAt(i)) {
                if(m == n) return s.substring(i+1,m).equals(t.substring(i+1,n));
                else if(m > n) return s.substring(i+1,m).equals(t.substring(i,n));
                else return s.substring(i,m).equals(t.substring(i+1,n));
            }
        }
        return true;
    }
}
