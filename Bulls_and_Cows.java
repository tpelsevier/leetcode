//Time O(N) Space O(N)
class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        Map<Character,Integer> sm = new HashMap<>();
        for(int i = 0;i<secret.length();i++){
            if(g[i] == s[i]) {
                bull++;
                g[i] =';';
                continue;
            }
            sm.put(s[i],sm.getOrDefault(s[i],0)+1);
        }
        for(int i = 0; i < guess.length();i++){
            if(g[i] == ';') continue;
            if(sm.containsKey(g[i]) && sm.get(g[i]) > 0){
                cow++;
                sm.put(g[i],sm.get(g[i])-1);
            }
        }
        return bull+"A"+cow+"B";
    }




    class Solution {
        public String getHint(String secret, String guess) {
            int len = secret.length();
            int[] counts = new int[10];
            int bull = 0, cow = 0;
            for(int i = 0;i<len;i++){
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                if(s == g) bull++;
                else{
                    if(counts[g] > 0) cow ++; // guess number store as negaive
                    if(counts[s] < 0) cow ++; // secret number store as postive
                    counts[s] ++;
                    counts[g] --;
                }
            }
            return bull +"A" + cow + "B";
        }
    }
