/*
  At least N citations on N paper
*/

//Time O(NlogN) Space O(1)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while(res < citations.length && res < citations[citations.length-1-res]) res++;
        return res;
    }
}

//Time O(N) Space O(N)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] len = new int[n+1];
        for(int i = 0; i<n;i++){
            len[citations[i] <= n? citations[i]:n]++;
        }
        int sum = 0;
        //Find the
        for(int i = n;i>0;i--){
            sum += len[i];
            if(sum >= i) return i;
        }
        return 0;
    }
}
