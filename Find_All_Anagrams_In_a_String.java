//Time O(N + M) Space O(1)
//Two pointer + sliding windows algorithms
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        for(char c: p.toCharArray()){
            count[c-'a']++;
        }
        //End tracks the end of the pattern
        //Start tracks the begining
        int start = 0, end = 0,co = p.length();
        while(end < s.length()){
            if(end - start  == p.length() && count[s.charAt(start++)-'a']++ >=0) co ++;
            if(count[s.charAt(end++) - 'a']-- >= 1) co --;
            if(co == 0) res.add(start);
        }
        return res;
    }
}
