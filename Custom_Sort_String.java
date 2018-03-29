//Time O(N+M) Space O(1)
class Solution {
    public String customSortString(String S, String T) {
        if(S.length() == T.length()) return S;
        int[] count = new int[26];
        //Get counts for each character in string T
        for(char c: T.toCharArray())count[c -'a']++;
        StringBuilder sb = new StringBuilder("");
        //Get counts for each character in string S
        for(char c: S.toCharArray()){
          //if c in this index, put all c in this index
            while(count[c-'a']-- > 0) sb.append(c);
        }
        for(int i = 0; i<26;i++) {
            while(count[i]-- > 0) sb.append((char)('a'+i));
        }
        return sb.toString();

    }
}
