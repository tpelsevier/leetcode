//Time O(N*L) Space O(N)
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        for(String word: words){
            if(map.containsKey(word)){
                count += map.get(word);
                continue;
            }

            int i = 0, j = 0;
            while(i < S.length() && j < word.length()){
                if(S.charAt(i) == word.charAt(j)){
                    i++;j++;
                }else i++;
            }
            if(j == word.length()){
                count ++;
                map.put(word,1);
            }else{
                map.put(word,0);
            }
        }
        return count;
    }
}
