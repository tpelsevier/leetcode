//Time O(MN) Space O(N)
class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] roots = new int[n];
        for(int i = 0;i<n;i++) roots[i] = i;
        for(int i = 0; i <n-1;i++){
            int root1 = getRoot(i,roots);
            for(int j = i+1;j < n;j++){ //Since previou row checks the relationship between i between 0->i
                if(M[i][j] == 1){
                    int root2 = getRoot(j,roots);
                    if(root1 != root2){
                        roots[root2] = root1;
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i < n; i++){
            if(i == roots[i]) count++;
        }
        return count;

    }
    private int getRoot(int i, int[] roots){
        while(i != roots[i]){
            i = roots[roots[i]];
        }
        return i;
    }
}
