//Time O(N) Space O(N)
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ls = new ArrayList<>();
        char [] cs = s.toCharArray();
        for(int i = 0;i<s.length()-1;i++){
            if(cs[i] == '+' && cs[i+1] =='+'){
                cs[i] = '-';
                cs[i+1] ='-';
                ls.add(String.valueOf(cs));
                cs[i] = '+';
                cs[i+1] = '+';
            }
        }
        return ls;
    }
}
