//Time O(N),Space O(N)
public int lengthOfLongestSubstring(String s) {
    Map<Character,Integer> map = new HashMap<>();
    int max = 0;
    for(int i = 0, j = 0;j<s.length();j++){
        char c=s.charAt(j);
        if(map.containsKey(c)){
           /*
           Compare the current char's
           last apperance index +1 with current head pointer's place
           */
            i = Math.max(i,map.get(c)+1);
        }
        map.put(c,j);
        max = Math.max(max,j-i+1);
    }
    return max;
}
