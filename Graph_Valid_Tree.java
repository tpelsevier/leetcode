
//Time O(N) Space O(N)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for(int i = 0; i < n;i++) roots[i] = i;
        for(int i = 0; i< edges.length;i++){
            int n1 = getRoot(edges[i][0],roots);
            int n2 = getRoot(edges[i][1],roots);
            if(n1 == n2) return false;
            roots[n1] = n2;
        }
        return edges.length == n-1;
    }
    public int getRoot(int i, int[] roots){
        while(i != roots[i]){
            i = roots[roots[i]];
        }
        return i;
    }
}
