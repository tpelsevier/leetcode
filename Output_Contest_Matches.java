//Time O(N+LOGN) Space O(N) 
class Solution {
    public String findContestMatch(int n) {
        List<String> ls = new ArrayList<>();
        for(int i = 1;i<=n;i++) ls.add(String.valueOf(i));

        while(ls.size() != 1){
            List<String> newRound = new ArrayList<>();
            for(int i = 0;i< ls.size()/2;i++)
                newRound.add("("+ls.get(i)+","+ls.get(ls.size()-i-1)+")");
            ls = newRound;
        }
        return ls.get(0);
    }
}
