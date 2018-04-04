//Time O(N) space O(N)
/*"DDIIDI"
  1234567
  3214576
*/
class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        for(int i = 0;i < n+1;i++) res[i] = i+1;
        for(int i = 0; i < n;i++){
            if(s.charAt(i) == 'D'){
                int j = i;
                while(i < n && s.charAt(i) == 'D') i++;
                reverse(j,i,res);
            }
        }
        return res;
    }
    private void reverse(int l, int h, int[] res){
        while(l < h) {
            res[l] = res[l]+res[h];
            res[h] = res[l] - res[h];
            res[l] -=res[h];
            l++;h--;
        }
    }
}
