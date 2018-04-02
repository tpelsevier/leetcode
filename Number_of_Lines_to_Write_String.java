//Time O(N) Space O(1)
class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        if(S.length() == 0) return new int[2];
        int full = 1,extra = 0;
        for(char c: S.toCharArray()){
            extra+=widths[c-'a'];
            if(extra > 100){
                full++;
                extra = widths[c-'a'];
            }
        }
        return new int[]{full,extra};
    }
}
