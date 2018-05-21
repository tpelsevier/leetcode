//Time O(V+E) Space O(M)
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,HashSet<Character>> map = new HashMap<>();
        for(String a: allowed){
            String substring = a.substring(0,2); //Store prefix in the map
            if(!map.containsKey(substring)) map.put(substring,new HashSet<>());
            map.get(substring).add(a.charAt(2));
        }
        return dfs(bottom,"",map,1);
    }
    private boolean dfs(String current, String next, Map<String,HashSet<Character>> map, int start){
        //Means this recursion reached it's end
        if(current.length() == 1) return true;
        //This means current row has been reached to it's end,
        //We are going to next row
        if(next.length()+1 == current.length()) return dfs(next,"",map,1);
        //Find the substring of the current row For example abcd  find the ab, then go the bc in next recursion
        for(Character c: map.getOrDefault(current.substring(start-1,start+1),new HashSet<Character>())){
            if(dfs(current,next+c,map,start+1)) return true;
        }
        return false;
    }
}
