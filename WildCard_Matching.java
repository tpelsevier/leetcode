//Time O(M*N)
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.equals("*")) return true;
        int si = 0, pi = 0, match = 0,star = -1;
        while(si < s.length()){
            if(pi < p.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?')){
                pi++; si++;
            }
            else if(pi<p.length() && p.charAt(pi) == '*'){
                star = pi;
                pi++;
                match = si;
            }else if(star != -1){
                pi = star + 1;
                match ++;
                si = match;
            }else return false;
        }
        while(pi < p.length() && p.charAt(pi) == '*'){
            pi++;
        }
        return pi == p.length();
    }
}
