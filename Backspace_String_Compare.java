//Time O(N+M) Space O(N+M)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return backspace(S).equals(backspace(T));
    }
    private String backspace(String S){
        StringBuilder a = new StringBuilder();
        for(int i = 0; i < S.length();i++){
            if(S.charAt(i) == '#'){
                if(a.length() != 0) a.deleteCharAt(a.length()-1);
            }else {
                a.append(S.charAt(i));
            }
        }
        return a.toString();
    }
}
