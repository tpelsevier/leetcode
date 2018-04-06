/*
The concept of this problem is store the case in bit wise
so A = 1 B = 10 C = 100 D = 1000 etc, since only 26 characters there
So find if two values don't share same value
and return the max product
*/

//Time O(N^2) Space O(N)
class Solution {
    public int maxProduct(String[] words) {
        if(words.length == 0 && words == null) return 0;
        int len = words.length;
        int [] val = new int[len];
        for(int i = 0; i < words.length;i++){
            String temp = words[i];
            for(char c: temp.toCharArray()){
                val[i] |= 1<<(c-'a');
            }
        }
        int max = 0;
        for(int i = 0;i<len;i++){
            for(int j =0;j<len;j++){
                if((val[i] & val[j]) == 0) max = Math.max(words[i].length() * words[j].length(),max);
            }
        }
        return max;
    }
}
