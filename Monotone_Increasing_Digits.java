/*
  735
  635 mark = 0
  699
*/
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] cs = String.valueOf(N).toCharArray();
        int mark = cs.length;//To mark where to start changing digit to 9
        for(int i = cs.length-1; i>0;i--){
            if(cs[i] < cs[i-1]){
                mark = i-1;
                cs[i-1]--;
            }
        }
        for(int i = mark+1; i<cs.length;i++)cs[i] = '9';
        return Integer.parseInt(String.valueOf(cs));
    }
}
