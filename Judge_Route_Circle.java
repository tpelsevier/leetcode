//Time O(N) space O(1)
class Solution {
    public boolean judgeCircle(String moves) {
        int[] pos = {0,0};
        for(Character c: moves.toCharArray()){
            if(c == 'U') pos[1] --;
            else if(c == 'D') pos[1] ++;
            else if(c =='L') pos[0] --;
            else if(c =='R') pos[0] ++;
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}
//Time O(N) Space O(1)
class Solution {
    public boolean judgeCircle(String moves) {
        int[] counts = new int[128];
        for(Character c: moves.toCharArray()){
            counts[c] ++;
        }
        return counts['L'] == counts['R']&&counts['U'] == counts['D'] ;
    }
}
