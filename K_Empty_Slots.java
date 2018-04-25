//Time O(NLogN) Space O(N)
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0;i < flowers.length;i++){
            ts.add(flowers[i]);
            Integer floor = ts.lower(flowers[i]);
            if(floor != null){
                if(flowers[i] - floor -1  == k) return i+1;
            }
            Integer ceiling = ts.higher(flowers[i]);
            if(ceiling != null){
                if(ceiling - flowers[i] -1 == k) return i+1;
            }
        }
        return -1;
    }
}
