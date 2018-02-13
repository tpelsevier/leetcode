//O(1) Since 12 and 60 are constant time space O(N)
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h ++) {
            for (int m = 0; m < 60; m ++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    if (m < 10) {
                        res.add(h + ":" + "0" + m);
                    } else {
                        res.add(h + ":" + m);
                    }
                }
            }
        }
        return res;
    }
}
//Backtracking solution O(N^2) Space O(N)
class Solution2 {
    public List<String> readBinaryWatch(int num) {
        int hours[] = new int[]{8,4,2,1}, mins[] = new int[]{32,16,8,4,2,1};
        List<String> res = new ArrayList<>();
        for(int i =0;i<=num;i++){
            List<Integer> hl = genDigits(hours,i);
            List<Integer> ml = genDigits(mins,num-i);
            for(Integer h: hl){
                if(h >=12) continue;
                for(Integer m:ml){
                    if(m >= 60)continue;
                    res.add(h+":"+(m<10?"0"+m:m));
                }
            }
        }
        return res;
    }
    public List<Integer> genDigits(int[]num,int count){
        List<Integer> ls = new ArrayList<>();
        helper(num,count,0,0,ls);
        return ls;
    }
    private void helper(int[] nums, int count, int pos,int sum,List<Integer> res){
        if(count == 0){
            res.add(sum);
            return;
        }
        for(int i = pos;i<nums.length;i++){
            helper(nums,count-1,i+1,sum+nums[i],res);
        }
    }
}
