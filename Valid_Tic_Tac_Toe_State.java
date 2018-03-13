//Time O(1) Space O(1)
class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] row = new int[3];
        int[] col = new int[3];
        int dia = 0, anti = 0;
        int x = 0, o = 0;
        boolean Xwon = false,Owon = false;
        for(int i = 0;i<3;i++){
            String s = board[i];
            for(int j =0;j<3;j++){
               char c = s.charAt(j);
               if(c == 'X'){
                   row[i]++;
                   col[j]++;
                   if(i+j+1 == 3) anti ++;
                   if(i == j) dia++;
                   x++;
                   if(col[j] == 3 || row[i] ==3 || dia == 3 || anti == 3){
                     if(Owon) return false; //If Owon then return false
                     else Xwon = true;
                   }
               }else if (c == 'O'){
                   if(i+j+1 == 3) anti--;
                   if(i == j) dia--;
                   row[i]--;
                   col[j]--;
                   o++;
                   if(col[j] == -3 || row[i] == -3 || dia == -3 || anti == -3){
                     if(Xwon) return false; //If X Won return false
                     else Owon = true;
                   }
               }
            }
        }
        //X always has more number than O
        //X can't larger than O by 2
        if(x < o || x - o >= 2) return false;
        //X Won and there should be one X more in the board
        //O Won and the number of x and y should be the same
        if((Xwon && x == o) || (Owon && x > o)) return false;
        return true;
    }
}
