//Time O(N) Space O(N)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for(int i = 0;i+9<s.length();i++){
            String add = s.substring(i,i+10); //substring
            if(!seen.add(add)) repeated.add(add); //If seen contains , repeated add
        }
        return new ArrayList<>(repeated);
    }
}
