//M = types of elements
//Time O(N+M) Space (M)
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int total = 0;
        for(int n:answers){
            if(n == 0) total++;
            else map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int key: map.keySet()){
            int group = map.get(key) / (key+1);
            total += map.get(key)%(key+1) == 0? group * (key+1):(group+1)*(key+1);
        }
        return total;
    }
}
