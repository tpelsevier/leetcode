//Time O(1) FOR isUnique O(N) for building maps Space O(N)
class ValidWordAbbr {
    HashMap<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary){
            String key = getKey(s);
            if(map.containsKey(key) && !map.get(key).equals(s)) map.put(key,"");
            else map.put(key,s);
        }
    }
    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    private String getKey(String word){
        return word.length() < 3? word:word.charAt(0)+""+(word.length()-2)+""+word.charAt(word.length()-1);
    }
}
