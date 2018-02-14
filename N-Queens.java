//Time O(N!) space O(N)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) return res;
        int [] rows = new int[n];
        helper(res,rows,0);
        return res;
    }
    private void helper(List<List<String>> res, int[] rows, int pos){
        if(pos == rows.length){
            addSolution(res,rows);
            return;
        }
        for(int i = 0; i<rows.length;i++){
            rows[pos] = i;
            if(isValid(rows,pos)) helper(res,rows,pos+1); //If put the col pos in this row is valid then continue;
        }

    }
    private boolean isValid(int[] rows, int pos){
        for(int i = 0;i<pos;i++)
            /*If there is a col pos of a row is equals to current rows col pos, it is false
            If the difference between two rows is equals to the difference between two col,
            then return false; Since it can attack each other
            */
            if(rows[i] == rows[pos] || Math.abs(rows[i] - rows[pos]) == Math.abs(i-pos)) return false;
        return true;

    }
    private void addSolution(List<List<String>> res, int[] rows){
        List<String> ls = new ArrayList<>();
        for(int i = 0;i<rows.length;i++){
            StringBuilder sb = new StringBuilder("");
            for(int j = 0; j < rows.length;j++){
                if(j == rows[i]) sb.append("Q");
                else sb.append(".");
            }
            ls.add(sb.toString());
        }
        res.add(ls);
    }
}
