//Time O(N) Space O(1)
class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];
        for(char c: t.toCharArray()){
            count[c]++;
        }
        int start = 0; //The start position
        int min = -1; //The length
        int total = t.length(); //Keep track how many needed in the current substring
        for(int i = 0,j = 0;i<s.length();i++){
            if(count[s.charAt(i)]-- > 0)total--;
            while(total == 0){
                int len = i - j +1;
                if(min == -1 || min > len) {
                    min = len;
                    start = j; 
                }
                if(++count[s.charAt(j++)] > 0) total++;
            }
        }
        return min == -1? "":s.substring(start,start+min);
    }
}
