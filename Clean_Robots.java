//Reference : http://www.1point3acres.com/bbs/thread-289514-1-1.html#postmessage_3399284
interface Robot {
    Stack<String> actions = new Stack<>(); // store completed actions. 1point3acres.com/bbs
    Stack<String> plans = new Stack<>();    // store future actions.
    int[] curPosition = new int[2]; // mark the position in the robot's view
    Set<String> visited = new HashSet<>(); // store the visited position
    // actions

    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean Move();
    // Robot will stay on the same cell after calling Turn*. k indicates hown many turns to perform.
    void TurnLeft(int k);.
    void TurnRight(int k);
    // Clean the current cell.
    void Clean();
    boolean Move(Direction d);

    // keep the facing direction when moving left / right. from: 1point3acres.com/bbs
    // String[] actions = new String[]{"Forward", "Left", "Right"};
    boolean MoveForward(){
        // actions.push("Forward");

        boolean success = Move();
        if(success) ++curPosition[1];
    }

    boolean MoveLeft(){
        // actions.push("Left");

        TurnLeft(1);
        boolean success = Move();
        if(success) --curPosition[0];
        TurnRight(1);
        return success;
    }

    boolean MoveRight(){
        // actions.push("Right");
        TurnRight(1);
        boolean success = Move();
        if(success) ++curPosition[0];. From 1point 3acres bbs
        TurnLeft(1);
        return success;
    }

    // explore new space
    boolean Actuator(String direction){
        if(direction.equals("Forward")){
            actions.push(direction);
            return MoveForward();
        }
        if(direction.equals("Left")) {
            actions.push(direction);
            return MoveLeft();
        }
        if(direction.equals("Right")){
            actions.push(direction);
            return MoveRight();
        }
        return false;
    }
    // return to the previous position
    boolean Return(){
        String lastAction = stack.pop();
        if(lastAction.equals("Left")) return MoveRight();
        if(lastAction.equals("Right")) return MoveLeft();
        if(lastAction.equals("Forward")) return MoveBackforward();
    }

    // main function
    boolean Solver(Robot robot){

        String posStr = posStr = curPosition[0] + "," + curPosition[1];
        visited.add(posStr);
        Clean();
        plans.push("Forward");
        plans.push("Left");
        plans.push("Right");
        while(!plans.empty()){
            String plan = plans.pop();
            if(!Actuator(plan)) {
                actions.pop();
                continue;
            }
            posStr = curPosition[0] + "," + curPosition[1];
            if(!visited.contains(posStr)){
                Clean();
                visited.add(posStr);
                plans.push("Forward");
                plans.push("Left");
                plans.push("Right");
            }else{
                Return();
            }
        }
        return true;
    }

}
