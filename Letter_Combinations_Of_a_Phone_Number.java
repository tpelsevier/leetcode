//Time O(N) space O(1);
class Solution {
    List<String> res = new ArrayList<>();
    private static String[] letters = {"","","abc","def","ghi","jkl","mno","prqs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backtracking(digits,0,"");
        return res;
    }
    private void backtracking(String digits,int pos,String curr){
        if(pos == digits.length()){
            res.add(curr);
            return;
        }
        String s= letters[digits.charAt(pos)-'0'];
       // if(s.equals("")) backtracking(digits,pos+1,curr);
        for(char c:s.toCharArray())
            backtracking(digits,pos+1,curr+c);


    }
}
