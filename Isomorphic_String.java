//Time O(N) Space O(N)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.equals(t)) return true;
        char[] map = new char[256];
        boolean[] used = new boolean[256];
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for(int i = 0; i< cs.length;i++){
            if(map[cs[i]] == 0){ //If current character is null in string s
                if(used[ct[i]]) return false; // if this character in ct is used return false
                map[cs[i]] = ct[i]; //put ct[i] to the map
                used[ct[i]] = true; //set this index to true
            }else{
                if(map[cs[i]] != ct[i]) return false; //if current map index of cs[i] is not ct[i] return false;
            }
        }
        return true;

    }
}
