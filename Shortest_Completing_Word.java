//Time O(N * M) Space O(N)
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        int[] cs = new int[26];
        int count = 0;
        for(char c: licensePlate.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){
                cs[c-'a']++;
                count ++;
            }
        }
        for(String word: words){
            int[] temp = cs.clone();
            int currCount = 0;
            for(char c: word.toCharArray()){
                if(temp[c-'a'] > 0) {
                    currCount++;
                    temp[c-'a']--;
                }
                if(currCount == count) break;
            }
            if(currCount == count && (ans.equals("") || word.length() < ans.length())) ans = word;
        }
        return ans;
    }
}
