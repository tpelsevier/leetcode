//123121
//Time O(K^N)  Space O(K^N)
class Solution {
    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n;i++) sb.append('0');
        Set<String> set = new HashSet<String>(){{
            add(sb.toString());
        }};
        dfs(n,k,total,set,sb);
        return sb.toString();
    }
    boolean dfs(int n, int k, int total, Set<String> visted, StringBuilder sb){
        if(visted.size() == total) return true;
        String prev = sb.substring(sb.length()-n+1,sb.length());
        for(int i = 0;i<k;i++){
            String next = prev+i;
            if(!visted.contains(next)){
                visted.add(next);
                sb.append(i);
                if(dfs(n,k,total,visted,sb)) return true;
                else{
                    sb.deleteCharAt(sb.length()-1);
                    visted.remove(next);
                }

            }
        }
        return false;
    }
}
