class SnakeGame {
    int width,height;
    Deque<int[]> snake = new ArrayDeque<>();
    int[][] food;
    int foodIndex = 0;
    boolean board[][];
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake.offer(new int[]{0,0});
        board = new boolean[height][width];
        board[0][0] = true;
    }
    public int move(String direction) {
        int[] headPos = new int[2];
        headPos[0] = snake.peekLast()[0];
        headPos[1] = snake.peekLast()[1];
        switch(direction){
            case "U":
                headPos[0]-=1;
                break;
            case "R":
                headPos[1]+=1;
                break;
            case "D":
                headPos[0]+=1;
                break;
            case "L":
                headPos[1]-=1;
                break;
        }
        int[] tail = snake.peekFirst();
        board[tail[0]][tail[1]] = false;
        if(headPos[0] < 0 || headPos[1] >= width || headPos[1] < 0 || headPos[0] >= height || board[headPos[0]][headPos[1]] ) return -1;
        if(foodIndex < food.length && food[foodIndex][0] == headPos[0] && food[foodIndex][1] == headPos[1]){
            snake.offer(headPos);
            board[tail[0]][tail[1]] = true;
            board[headPos[0]][headPos[1]] = true;
            foodIndex++;
        }else{
            snake.poll();
            snake.offer(headPos);
            board[headPos[0]][headPos[1]] = true;
        }
        return snake.size()-1;
    }
}
