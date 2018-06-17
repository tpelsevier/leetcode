//Time O(N) Space O(N)
class Solution {
    public int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        return helper(a,b,0,0);
    }
    private int helper(char[] now, char[] target, int start, int count){
        if(start >= now.length) return count;
        if(now[start] == target[start]){
            return helper(now,target,start+1,count);
        }
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
