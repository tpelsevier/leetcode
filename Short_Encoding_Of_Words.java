//Time O(N*L) Space O(N)
class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        for(String s: words){
          //To see the set contains it's substring
            for(int i = 1; i<s.length();i++) set.remove(s.substring(i));
        }
        int res = 0;
        for(String s: set) res += s.length()+1;
        return res;
    }
}
