//Time O(N) space O(1)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] i = new int[256];
        int max = 0,count = 0;
        for(int st = 0,e = 0;e<s.length();e++){
            if([s.charAt(e)]++ == 0) count ++; //This means there a new character come in
            if(count >= k) {
                while(--i[s.charAt(st++)] > 0);
                count--;
            }
            max = Math.max(e-st+1,max);
        }
        return max;
    }
}
