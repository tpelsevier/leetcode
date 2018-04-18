//Time O(N) Space O(1)
class Solution {
    public boolean canPermutePalindrome(String s) {
        int n = s.length();
        int[] set = new int[256];
        int num = 0; //Count how many one are there in the array
        for(char c: s.toCharArray()){
            if(set[c] == 0){
                set[c] ++;
                num++;
            }else{
                set[c]--;
                num--;
            }
        }

        return num == 0 || num == 1;
    }
}
