//Time O(1) Space O(1)
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0],rec2[0]) < Math.min(rec1[2],rec2[2]) && Math.max(rec1[1],rec2[1]) < Math.min(rec1[3],rec2[3]);
    }
}
/*
    ________
    |      /|
____|___ /  |
|   |  /|   |
|   |/__|___|
|/_____|
The max of the x and y axies of Left corner point should be
less than the min of the x and y axies of the right corner point
*/
