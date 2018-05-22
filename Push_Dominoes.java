//Time O(N) Space O(N)
class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes.length() < 2 || dominoes.indexOf(".") == -1) return dominoes;
        //Corner case start point and end point starts with "."
        dominoes = "L" + dominoes +"R";
        int len = dominoes.length();
        StringBuilder sb = new StringBuilder();
        char[] cs = dominoes.toCharArray();
        for(int i = 0,j = 1; j <len;j++){
            if(cs[j] == '.') continue;
            int length = j - i -1;
            //We are going to at index of 0 since it is extra
            if(i > 0) sb.append(cs[i]);
            if(cs[i] == cs[j]){ //If L.....L=LLLLLLL
                for(int z = 0; z<length;z++) sb.append(cs[i]);
            }
            else if(dominoes.charAt(i) == 'L' && dominoes.charAt(j) == 'R'){ //L......R = L.......R
                for(int z = 0; z < length;z++) sb.append(".");
            }else{
                //R......L = RRRRLLLL   R.......L = RRRR.LLLL
                for(int z = 0; z < length/2;z++) sb.append("R");
                if(length%2 == 1) sb.append(".");
                for(int z = 0; z < length/2;z++) sb.append("L");
            }
            //The first pointer equal to the index of second pointer
            //And start from i to find the next index which is not '.'
            i = j;
        }
        return sb.toString();
    }
}
