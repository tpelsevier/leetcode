//Time O(N) Space O(N)
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        int sum = 1;
        for(int i = 1;i <= n;i++){
            res.add(i);
            sum*= i;
        }
        /*
          k - 1 because of index off
          because we have n = 3 and k = 6
          1 , 2 , 3
          6/2 = 3 which 3 is off index so we need to minus 1 to make up the offset
          which is 5/2 = 2
        */
        return helper(sum/n, k-1, res, new StringBuilder());
    }
    private String helper(int part, int k,List<Integer> res, StringBuilder sb){
        int removeIndex = k/part;
        sb.append(res.get(removeIndex));
        res.remove(removeIndex);
        if(res.isEmpty()) return sb.toString();
        //K % part means remaining value after divided current part, how much we have remaining
        //Which will be point to the next level
        return helper(part/res.size(), k%part, res, sb);
    }
}
