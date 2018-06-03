//Time O(NLogN) Space O(N)
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int n: hand){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        while(!map.isEmpty()){
            int first = map.firstKey();
            for(int i = 0; i < W;i++){
                int next = first + i;
                if(map.getOrDefault(next,0) == 0) return false;
                map.put(next,map.get(next)-1);
                if(map.get(next) == 0) map.remove(next);
            }
        }
        return true;
    }
}
