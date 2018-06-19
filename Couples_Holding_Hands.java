//Time O(N) Space O(1)
class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];
        for(int i = 0; i < n;i++){
            pos[row[i]] = i;
        }
        int count = 0;
        for(int i = 0; i < n;i+=2){
            int x = row[i];
            int half = x^1;
            if(row[i+1] == half) continue;
            count++;
            int ind = pos[half]; //Find the index of the half of row i
            pos[row[i+1]] = ind; //Set the index of current value of at i+1 to the pos of the half
            row[ind] = row[i+1]; //Swap
            row[i+1] = x^1;//Swap
            pos[x^1] = i+1;// Set the index of half to i+1
        }
        return count;
    }
}
