//Time O(N!) space O(N);
class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0) return count;
        int [] rows = new int[n];
        helper(rows,0);
        return count;
    }
    private void helper(int[] rows, int pos){
        if(pos == rows.length){
            count++;
            return;
        }
        for(int i = 0; i<rows.length;i++){
            rows[pos] = i;
            if(isValid(rows,pos)) helper(rows,pos+1);
        }

    }
    private boolean isValid(int[] rows, int pos){
        for(int i = 0;i<pos;i++)
            if(rows[i] == rows[pos] || Math.abs(rows[i] - rows[pos]) == Math.abs(i-pos)) return false;
        return true;

    }
}
