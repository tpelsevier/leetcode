//Time max(O(nlogn), O(mlogn)) Space O(1)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for(int house: houses){
            int index = Arrays.binarySearch(heaters,house);
            if(index < 0){
                index = ~index;
                //Find the house between two heaters
                int d1 = index - 1 >= 0 ?house-heaters[index-1]:Integer.MAX_VALUE;
                int d2 = index < heaters.length? heaters[index] - house:Integer.MAX_VALUE;
                res = Math.max(res,Math.min(d1,d2));
            }
        }
        return res;
    }
}
