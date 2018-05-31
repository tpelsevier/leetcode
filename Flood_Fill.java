/*
    1 1 1     2 2 2
    1 1 0     2 2 0
    1 0 1     2 0 1
*/
//Time O(V+E) Space O(1)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,newColor,oldColor);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc,int newColor, int oldColor){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor || image[sr][sc] == newColor) return;
        image[sr][sc] = newColor;
        dfs(image,sr+1,sc, newColor,oldColor);
        dfs(image,sr-1,sc, newColor,oldColor);
        dfs(image,sr,sc+1, newColor,oldColor);
        dfs(image,sr,sc-1, newColor,oldColor);
    }
}
