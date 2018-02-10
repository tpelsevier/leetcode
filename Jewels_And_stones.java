//Time O(N) Space O(N)
class Solution {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> map = new HashMap<>();
        //Find the counds of each stones
        for(char c:S.toCharArray()){
            if(!map.containsKey(c)) map.put(c,1);
            else map.put(c,map.get(c)+1);
        }
        int count = 0;
        //Now start counting
        for(char c: J.toCharArray()){
            if(map.containsKey(c)) count += map.get(c);
        }
        return count;
    }
}
