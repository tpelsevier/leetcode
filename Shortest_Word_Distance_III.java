//Time O(N) Space O(1)
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int wi1 = -1, wi2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<words.length;i++){
            if(words[i].equals(word1)){
                wi1 = i;
                //Do not put them in the same index
                if(wi2 != wi1 && wi2 != -1) min = Math.min(min,Math.abs(wi1-wi2));
            }
            if(words[i].equals(word2)){
                wi2 = i;
                //Do not put them in the same index
                if(wi2 != wi1 && wi1 !=-1) min = Math.min(min,Math.abs(wi1-wi2));
            }
        }
        return min;
    }
}
