//Time O(1) Space O(1)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] map = new int[121];
        int count = 0;
        for(int age: ages) {
            if(age > age * 0.5 + 7){
                count += 2*map[age];
            }
            map[age]++;
        }
        for(int i = 120;i>=0;i--){
            if(map[i] > 0){
                 for(int j = i-1;j>i/2+7;j--){
                    if(map[j] > 0) count+=map[i] * map[j];
                 }
            }
        }
        return count;
    }
}
