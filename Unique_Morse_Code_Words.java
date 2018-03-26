//Time O(N * L) Space O(N)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String [] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String s: words){
            StringBuilder sb = new StringBuilder();
            for(Character c: s.toCharArray()){
                sb.append(codes[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
