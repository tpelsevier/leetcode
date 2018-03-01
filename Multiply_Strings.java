//Time O(N*M) space O(N+M)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int [] vals = new int[m+n];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1; j >= 0;j--){
                int secondPos = i+j+1,firstPos = i+j;
                //In case of position1 of last iteration has value left so just plus that
                int mul = (num2.charAt(j) -'0')*(num1.charAt(i)-'0') + vals[secondPos];
                /*
                  This plus equals mul /10 because
                  1 2 3
                X 4 5 6
                --------
                  7 3 8   when position1 moves to the index of 3 or 7 it already has 5 or 1 in that index, it will needed to be added up
                6 1 5
              1 9 2
              ------------

                */
                vals[firstPos] += mul / 10;
                vals[secondPos] = mul %10;
            }
        }
        int i = vals[0] == 0? 1:0;
        StringBuilder sb = new StringBuilder();
        for(;i<vals.length;i++) sb.append(String.valueOf(vals[i]));
        return sb.toString();
    }
}
