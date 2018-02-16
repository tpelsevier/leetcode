//Time O(mn) space O(1)
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
               if(word.charAt(0) == board[i][j] && ex(board,word,i,j,0)) return true;  //If the first letter match,then start search
            }
        }
        return false;
    }
    private boolean ex(char[][] board,String word,int i, int j, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j]) return false;
        board[i][j] ^= 256; //Mark it as visted node
        boolean r = ex(board,word,i+1,j,index+1) || ex(board,word,i-1,j,index+1) ||ex(board,word,i,j+1,index+1) ||ex(board,word,i,j-1,index+1);
        board[i][j] ^= 256; //Change it back
        return r;
    }

}
