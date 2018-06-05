//Time O(N^2) Space O(N)
class Solution {
    public int maximumSwap(int num) {
        int max = num;
        char[] cs = String.valueOf(num).toCharArray();
        for(int i = 0; i < cs.length;i++){
            for(int j = 1; j < cs.length;j++){
                if(cs[i] < cs[j]){
                    swap(i,j,cs);
                    max = Math.max(max, Integer.parseInt(String.valueOf(cs)));
                    swap(i,j,cs);
                }
            }
        }
        return max;
    }
    private void swap(int i ,int j, char[] cs){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
//Time O(N) Space O(N)
class Solution {
    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        for(int i = 0; i<cs.length;i++){
            last[cs[i]-'0'] = i; //Store the last occurence of the digit
        }
        for(int i = 0; i < cs.length;i++){
            for(int j = 9; j > cs[i]-'0';j--) {
              //If last digit that is greater than current pos, means it is the largest
                if(last[j] > i){
                    char temp = cs[last[j]];
                    cs[last[j]] = cs[i];
                    cs[i] = temp;
                    return Integer.parseInt(String.valueOf(cs));
                }
            }
        }
        return num;
    }
}
