//Time(N*M + N+M) Space O(N+M)
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;
        int[] rowCount = new int[n];
        int[] colCount = new int[m];
        for(int i = 0; i< picture.length;i++){
            for(int j = 0; j < picture[0].length;j++){
                if(picture[i][j] == 'B'){
                    rowCount[i]++; // Get counts of B in row i
                    colCount[j]++; //Get counts of B in col j
                }
            }
        }
        int count = 0;
        for(int r: rowCount){
            if(r == 1) count++;
        }
        int count2 = 0;
        for(int c: colCount){
            if(c == 1) count2++;
        }
        // [['B','B','B']] we will have 3 B in a same row, 0 in the same col
        //So choose the smallest one
        return Math.min(count,count2);
    }
}
