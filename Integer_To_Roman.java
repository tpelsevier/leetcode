//Time (1) Space O(1)
class Solution {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length;i++){
            while(values[i] <= num){
                sb.append(strs[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
