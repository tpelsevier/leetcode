/*
This question means if two cards are same number in both back and front
it will not be the smallest value no matter how we flip it
*/

//Time O(N) Space O(N)
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        HashSet<Integer> same = new HashSet<>();
        for(int i = 0; i< fronts.length;i++) if(fronts[i] == backs[i]) same.add(fronts[i]);
        if(same.size() == fronts.length) return 0;
        int res = 3000;
        for(int f: fronts) if(!same.contains(f)) res = Math.min(res,f);
        for(int b: backs) if(!same.contains(b)) res = Math.min(res,b);
        return res%3000;
    }
}
