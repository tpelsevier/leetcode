//Time O(V+E) Space O(N)
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends)); //Treat it as a visted set
        Set<String> begin = new HashSet<String>(){{add("0000");}};
        Set<String> end = new HashSet<String>(){{add(target);}};
        if(dead.contains("0000")) return -1;
        int steps = 0;
        Set<String> temp;
        while(!begin.isEmpty() && !end.isEmpty()){
          //Swap between two seats
            if(begin.size() > end.size()){
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for(String next: begin){
                if(end.contains(next)) return steps;
                if(!dead.add(next)) continue;
                for(int i = 0; i < 4; i++){
                    char c = next.charAt(i);
                    String st1 = next.substring(0,i)+(c == '9'?0: c - '0' + 1) + next.substring(i+1);
                    String st2 = next.substring(0,i)+(c == '0'? 9: c - '0' - 1) + next.substring(i+1);
                    if(!dead.contains(st1)){
                        temp.add(st1);
                    }
                    if(!dead.contains(st2)){
                        temp.add(st2);
                    }
                }
            }
            begin = temp; //Assign temp to be the next step
            steps++;
        }
        return -1;
    }
}
