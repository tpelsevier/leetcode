//Time O(N) space O(N)
/*
color 0 means unvisted node
Switch between color 1 and color -1
if current node equals to 1, so it's adjencent node is -1
*/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length;i++){
            if(colors[i] == 0 && !isValid(graph,i,colors,1))
                return false;
        }
        return true;
    }
    private boolean isValid(int[][] graph,int start, int[] colors,int color){
        if(colors[start] != 0){
            return colors[start] == color;
        }
        colors[start] = color;
        for(int next: graph[start]){
            if(colors[next] != 0 && colors[next] != -color) return false;
            if(!isValid(graph,next,colors,-color)) return false;
        }
        return true;
    }
}
