//Time O(NLOGN) Space O(1)
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = piles[0];
        for(int i = 1; i < piles.length;i++) {
            max = Math.max(piles[i],max);//find the max
        }
        int min = 1;
        while(min < max) {
            int mid = min + (max - min)/2;
            //can finish with mid
	    if(canFinish(mid,piles,H)){
                max = mid;
            }else{
                min = mid +1;
            }
        }
        return min;
    }
    private boolean canFinish(int mid, int[] piles, int H) {
        double sum = 0.0;
        for(int p: piles) {
	    //Time spend in pile[i] if the speed is mid
            sum += Math.ceil((double)(p)/mid);
            if(sum > H) return false;
        }
        return true;
        
    }
}
