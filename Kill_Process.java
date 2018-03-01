//Time O(N) Space O(N) BFS technique
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i< ppid.size();i++){
            if(!map.containsKey(ppid.get(i))) map.put(ppid.get(i),new ArrayList<Integer>());
            map.get(ppid.get(i)).add(pid.get(i)); //One process can have more than one children process
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res.add(curr);
            if(!map.containsKey(curr)) continue;
            for(Integer i: map.get(curr)){
                queue.add(i);
            }
        }
        return res;
    }
}
//Time O(N) Space O(N) DFS technique
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i< ppid.size();i++){
            if(!map.containsKey(ppid.get(i))) map.put(ppid.get(i),new ArrayList<Integer>());
            map.get(ppid.get(i)).add(pid.get(i)); //One process can have more than one children process
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while(!stack.isEmpty()){
            int curr = stack.pop();
            res.add(curr);
            if(!map.containsKey(curr)) continue;
            for(Integer i: map.get(curr)){
                stack.push(i);
            }
        }
        return res;
    }
}
