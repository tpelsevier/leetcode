//Time O(N^2) space O(N)
class Solution {
    public int countArrangement(int N) {
        return helper(new boolean[N+1],N,1);
    }
    private int helper(boolean[] ls, int N,int pos){
        if(pos == N+1) return 1;
        if(pos > N+1) return 0;
        int count = 0;
        for(int i = 1;i<=N;i++){
            if(ls[i]) continue;
            if(pos % i == 0 || i%pos == 0){
                ls[i] = true;
                count+=helper(ls,N,pos+1);
                ls[i] = false;
            }
        }
        return count;

    }
}
//Back tracking solution
class Solution {
    int count = 0;
    public int countArrangement(int N) {
        helper(0,new boolean[N+1],N);
        return count;
    }
    private void helper(int n, boolean[] visited, int N){
        if(n == N){
            count ++;
            return;
        }
        for(int i = 1; i <= N;i++){
            if(visited[i] || (i % (n+1) != 0 && (n+1)%i != 0))continue;
            visited[i] = true;
            helper(n+1,visited,N);
            visited[i] = false;
        }

    }
}
