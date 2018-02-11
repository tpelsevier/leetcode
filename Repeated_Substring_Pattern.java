//Time O(N(logN)) Space O(N);
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();
       for(int i = 1;i<s.length()/2+1;i++){
            if(l%i != 0) continue;
            String sub = s.substring(0,i);
            StringBuilder sb = new StringBuilder();
            int re = l / i;
            while(re-->=1){
                sb.append(sub);
            }
           if(sb.toString().equals(s)) return true;
       }
       return false;
    }
}
