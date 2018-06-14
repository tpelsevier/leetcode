//Time O(N) Space O(1)
class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), k ,0,s.length());
    }
    private int helper(char[] cs, int k, int left, int right){
        //If right minus left index has smaller amount than K,
        //Then it definitely can't be greater than K
        if(right - left < k) return 0;
        int[] count = new int[26];
        for(int i = left; i< right;i++){
            //Find the count of the character start from left to right
            count[cs[i] -'a']++;
        }
        for(int i = left; i < right;i++){
            if(count[cs[i] -'a'] < k){
                int j = i + 1;
                //J indicates the next char that has amount that is greater than k
                while(j < right && count[cs[j] -'a'] < k) j++;
                return Math.max(helper(cs,k,left,i), helper(cs,k,j,right));
            }
        }

        return right - left;
    }
}
