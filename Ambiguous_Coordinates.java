//Time O(N) Space O(N)
class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        for(int i = 1; i < len-2;i++){
            List<String> first = helper(S.substring(1,i+1)), second = helper(S.substring(i+1,len-1));
            for(String a: first){
                for(String b: second){
                    res.add("("+a+", "+b+")");
                }
            }
        }
        return res;
    }
    private List<String> helper(String s){
        int n = s.length();
        List<String> res = new ArrayList<>();
        if(n == 0 || (n > 1 && s.charAt(0) =='0' && s.charAt(n-1) == '0')) return res;
        if(n > 1 && s.charAt(0) == '0'){
            res.add("0."+s.substring(1));
            return res;
        }
        res.add(s);
        if(s.equals("0") || s.charAt(n-1) == '0') return res;
        for(int i = 1; i < n;i++) res.add(s.substring(0,i)+"."+s.substring(i));
        return res;
    }
}
