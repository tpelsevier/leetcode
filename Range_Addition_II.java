//Time O(N) Space O(1)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops == null || ops.length == 0) return m*n;
        for(int[] op: ops){
            m = Math.min(op[0],m);
            n = Math.min(op[1],n);
        }
        return m*n;
    }
}
