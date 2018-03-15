//Time O(Log N) Space O(N)
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0;i<n;i++) root[i] =i;
        for(int[] e: edges){
            if(root[e[0]] != root[e[1]]){
                int a = e[0];
                while(a != root[a]) {
                    root[a] = root[root[a]];
                    a = root[a];
                }
                int b = e[1];
                while(b!=root[b]){
                    b = root[b];
                }
                root[b] = a;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int r: root){
            while(r != root[r]){
                root[r] = root[root[r]];
                r=root[r];
            }
            set.add(r);
        }
        return set.size();
    }
}
