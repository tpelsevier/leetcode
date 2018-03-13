//Time O(N) Space O(N)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s: strings){
            String key = "";
            //Calculate the key
            for(int i = 1; i<s.length();i++){
                int off = s.charAt(i)-s.charAt(i-1);
                key += off <0? off+26:off; //Corner case: "za"
            }
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
