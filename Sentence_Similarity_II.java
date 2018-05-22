//Time O(N+K) Space O(K)
class Solution {
    HashMap<String,String> map = new HashMap<>();
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length ) return false;
        for(String[] pair: pairs){
            String r1 = findRoot(pair[0]);
            String r2 = findRoot(pair[1]);
            if(!r1.equals(r2)) map.put(r1,r2);
        }    HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < words2.length;i++){
            String r1 = findRoot(words1[i]);
            String r2 = findRoot(words2[i]);
            if(!r1.equals(r2)) return false;
        }
        return true;

    }
    private String findRoot(String w){
        while(true){
            String p = map.get(w);
            if(p == null) return w;
            w = p;
        }
    }
}
