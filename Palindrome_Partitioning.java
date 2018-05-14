//Time O(N^2) Space O(1)
class Solution {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(result,s,0,new ArrayList<>());
        return result;
    }
    private void helper(List<List<String>> result, String s, int start,List<String> temp){
        if(start >= s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                helper(result,s,i+1,temp);
                temp.remove(temp.size()-1);
            }
        }

    }
    private boolean isPalindrome(String string, int s, int e){
        while(s <= e){
            if(string.charAt(s) != string.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
