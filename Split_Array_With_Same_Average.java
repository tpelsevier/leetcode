//Time O(N^2) Space O(N)
//Reference: https://www.youtube.com/watch?v=FBQbm26tSzA
class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0, len = A.length;
        for(int a: A) sum+=a;
        if(!isPossible(len,sum)) return false;
        List<Set<Integer>> ls = new ArrayList<>();
        for(int i =0; i<=len/2;i++) ls.add(new HashSet<>());
        ls.get(0).add(0);
        for(int a: A){
            for(int i = ls.size()-1;i>0;i--){
                if(ls.get(i-1).size() > 0){
                    for(int n: ls.get(i-1)) ls.get(i).add(n+a);
                }
            }
        }
        for(int i = 1 ;i < ls.size(); i++){
            if(sum*i%len == 0 && ls.get(i).contains(sum*i/len)) return true;
        }
        return false;

    }
    boolean isPossible(int len, int sum){
        for(int i = 1; i < len;i++){
            if(sum * i % len == 0) return true;
        }
        return false;
    }
}
