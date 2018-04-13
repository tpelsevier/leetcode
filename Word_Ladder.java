//Time O(N*L) Space O(N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> words = new HashSet<>(wordList);
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);
        words.remove(beginWord);
        words.remove(endWord);
        int dis = 1;
        while(!start.isEmpty()){
            HashSet<String> toAdd = new HashSet<>();
            for(String q: start){
                char[] w = q.toCharArray();
                for(int z = 0; z < q.length();z++){
                    char ori = w[z];
                    for(char j = 'a'; j <= 'z';j++){
                        w[z] = j;
                        String newString = new String(w);
                        if(end.contains(newString)) return dis+1;
                        if(words.contains(newString)){
                            toAdd.add(newString);
                            words.remove(newString);
                        }
                    }
                    w[z] = ori;
                }
            }
                dis++;
                start = toAdd.size() < end.size()?toAdd:end;
                end = start.size() < end.size()?end:toAdd;
        }
        return 0;
    }
}
