//Time O(N) Space O(N)
class Solution {
  //Overall idea is to make the string at the begining the same
  //Then start swapping rest of the arrays
    public int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        return helper(a,b,0,0);
    }
    private int helper(char[] now, char[] target, int start, int count){
        //If the start is greater than now length
        if(start >= now.length) return count;
        //Continue to next index if they are equal
        if(now[start] == target[start]){
            return helper(now,target,start+1,count);
        }
        //If there is no match element at end
        //It only returns the MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = start+1; i < now.length;i++){
            if(now[i] == target[i] || now[i] != target[start]) continue;
            swap(now,start,i);
            min = Math.min(min,helper(now,target,start+1,count+1));
            swap(now,start,i);
        }
        return min;
    }
    private void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
