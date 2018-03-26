//Time O(N) Space O(N)
class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean canWin(String s) {
        if(s==null || s.length()<2) return false;
        if(map.containsKey(s))return map.get(s);
        for(int i = 0; i < s.length()-1;i++){
            if(s.startsWith("++",i)){
              //Try all the possible solution
                String t = s.substring(0,i)+"--"+s.substring(i+2,s.length());
                if(!canWin(t)) {
                    map.put(s,true); //Mark current string has been visted
                    return true;
                }
            }
        }
        map.put(s,false); //Mark current string has been visted
        return false;

    }

}
