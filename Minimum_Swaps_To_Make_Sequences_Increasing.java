//Time O(N) Space O(1)
class Solution {
    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        //Calculate swap and non swap element
        int n1 = 0, s1 = 1;
        for (int i = 1; i < N; ++i) {
            int n2 = N, s2 = N;
            //Means it keeps it's original order
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                n2 = Math.min(n1,n2);
                s2 = Math.min(s2,s1+1);
            }
            //Means it has to be swap
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                //If previous if statement is not trigger, so n2 will be equals to s1 since we need at least s1 swap chance
                n2 = Math.min(n2,s1);
                  //If previous if statement is trigger, previous no swap will be equals to noswap + 1
                s2 = Math.min(s2,n1+1);
            }
            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1,s1);
    }
}
