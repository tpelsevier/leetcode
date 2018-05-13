//Time O(N*M) Space O(1)
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int[] index = new int[]{1,0};
        for(int[] a: A){
            int start = 0, end = a.length-1;
            while(start < end){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                a[start] = index[a[start]];
                a[end] = index[a[end]];
                start++;
                end--;
            }
            if(start == end) a[start] = index[a[start]];
        }
        return A;
    }
}
