//123121
//Time O(K^N)  Space O(K^N)
class Solution {
    /*
        @param n means password length is n
        @param k means password is form from 0 to k-1
    */
    public String crackSafe(int n, int k) {
        int total = (int) Math.pow(k,n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n;i ++){
            sb.append("0");
        }
        HashSet<String> set = new HashSet<String>(){{
           add(sb.toString());
        }};
        dfs(sb,set,total,n,k);
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb, HashSet<String> visited, int total, int n, int k){
        if(visited.size() == total) return true;
        String prev = sb.substring(sb.length()-n+1);
        for(int i = 0; i < k;i++){
            String next = prev + i;
            if(visited.add(next)){
                sb.append(i);
                if(dfs(sb,visited,total,n,k)) return true;
                else {
                    sb.deleteCharAt(sb.length()-1);
                    visited.remove(next);
                }
            }
        }

        return false;
    }

}
