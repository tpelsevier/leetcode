//Time O(NlogN) Space O(N)
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            tm.putIfAbsent(A[i],0);
            tm.put(A[i],tm.get(A[i])+1);
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            Integer higher = tm.higherKey(B[i]); // get the key higher than B[i]
            if(higher == null) {
                res[i] = tm.firstKey(); //IIf not add the smallest key
            }else{
                res[i] = higher;
            }
            tm.put(res[i],tm.get(res[i])-1);
            if(tm.get(res[i]) == 0) tm.remove(res[i]);
        }
        return res;
    }
}
