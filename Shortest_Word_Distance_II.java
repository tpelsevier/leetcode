//Time O(freq(w1) * freq(w2)) space O(N)
class WordDistance {
    Map<String,ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i<words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i],new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        ArrayList<Integer> a = map.get(word1);
        ArrayList<Integer> b = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(int i: a){
            for(int j: b){
                if(min == 1) return min;
                min = Math.min(min,Math.abs(i-j));
            }
        }
        return min;
    }
}
