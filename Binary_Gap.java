//Time O(N) Space O(1)
class Solution {
    public int binaryGap(int N) {
        String b = Integer.toBinaryString(N);
        int res = 0, prev = -1;
        for(int i = 0; i < b.length(); i ++){
            if(b.charAt(i) == '1'){
                if(prev != -1){
                    res = Math.max(i-prev,res);
                }
                prev = i;
            }
        }
        return res;
    }
}
