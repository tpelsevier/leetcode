//Time O(1) Space O(1)
class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0, step = 0;
        while(sum < target){
            step++;
            sum+=step;
        }
        // TARGET = 5
        // 1 -> 2 -> 3 = 6
        // 1 -> 2 -> 3 -> 4 -> 5 = 15 - 5 = 10
        //as long as the summation of the changed value equals to half of the difference.
        // We can switch 1 and 4 or 2 and 3 or 5.
        if(sum == target) return step;
        while((sum-target)%2 != 0){
            step++;
            sum+=step;
        }
        return step;
    }
}
