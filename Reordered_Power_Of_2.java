//Time O(N!) Space O(N)
class Solution {
    public boolean reorderedPowerOf2(int N) {
        if((N & (N - 1)) == 0) return true;
        char[] cs = String.valueOf(N).toCharArray();
        return helper(cs,new StringBuilder(),new boolean[cs.length]);
    }
    private boolean helper(char[] cs, StringBuilder curr,boolean[] visited) {
        if(curr.length() == cs.length){
            int N = Integer.parseInt(curr.toString());
            if((N & (N - 1)) == 0) return true;
        }
        for(int i = 0; i < cs.length;i++) {
            if(visited[i]) continue;
            if(curr.length()==0 && cs[i] == '0') continue;
            visited[i] = true;
            curr.append(cs[i]);
            if(helper(cs,curr,visited)) return true;
            visited[i] = false;
            curr.deleteCharAt(curr.length()-1);

        }
        return false;
    }
}
