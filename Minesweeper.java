//Time O(M*N) space O(2^(M*N))
//DFS Solution
class DFS_Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int r = click[0],c = click[1];
        int cs = 0;
        if(board[r][c] == 'M') board[r][c]='X'; //Game over!
        else {
                for(int i = -1;i<2;i++){ //Find how many mimes aroud this position
                    for(int j=-1;j<2;j++){
                        if(i == 0 && j == 0) continue;
                        int row = r + i, col = c+j;
                        if(row < 0 || col < 0 || row >=board.length || col >= board[0].length) continue;
                        if(board[row][col] == 'X' || board[row][col] == 'M') cs++;
                    }
                }

            if(cs > 0) board[r][c] = (char)(cs+'0');
            else{
                board[r][c] = 'B'; //Set curr pos to B represented as blank
                for(int i = -1; i <2;i++){
                    for(int j = -1; j <2;j++){
                        if(i == 0 && j == 0) continue;
                        int row = r +i, col = c +j;
                        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) continue;
                        if(board[row][col] == 'E') updateBoard(board,new int[]{row,col}); //If adjacent cell is E , start from the pos again
                    }
                }
            }
        }



        return board;
    }
}
//Time complexity O(MNLog) space O(N) 
class BFSSolution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<>(); //Make a queue
        queue.add(click);
        while(!queue.isEmpty()){
            click = queue.poll();
            int r = click[0],c = click[1];
            int cs = 0;
            if(board[r][c] == 'M') board[r][c]='X'; //Game over
            else{
                for(int i = -1;i<2;i++){
                    for(int j=-1;j<2;j++){
                        if(i == 0 && j == 0) continue;
                        int row = r + i, col = c+j;
                        if(row < 0 || col < 0 || row >=board.length || col >= board[0].length) continue;
                       if(board[row][col] == 'X' || board[row][col] == 'M') cs++;
                    }
                }

                if(cs > 0) board[r][c] = (char)(cs+'0');
                else{
                    board[r][c] = 'B';
                    for(int i = -1; i <2;i++){
                        for(int j = -1; j <2;j++){
                            if(i == 0 && j == 0) continue;
                            int row = r +i, col = c +j;
                            if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) continue;
                            if(board[row][col] == 'E') {
                                queue.add(new int [] {row,col});
                                board[row][col] = 'B';
                            }

                        }
                    }
                }
            }
        }

        return board;
    }
}
