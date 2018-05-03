//Time O(N) Space O(N)
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(S.toLowerCase().toCharArray(),0,res);
        return res;
    }
    private void helper(char[] cs, int index,List<String> res){
        if(index == cs.length){
            res.add(new String(cs));
            return;
        }
        helper(cs,index+1,res);
        if(Character.isAlphabetic(cs[index])){
            cs[index] = (char) (cs[index] -'a'+'A');
            helper(cs,index+1,res);
            cs[index] = (char) (cs[index] -'A'+'a');
        }
    }

}
