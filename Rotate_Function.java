//Time O(N) space O(1)
public int maxRotateFunction(int[] A) {
    int allSum = 0;
    int len = A.length;
    int F = 0;
    //Get the total sum of the first rotation and sum of all array elements
    for (int i = 0; i < len; i++) {
        F += i * A[i];
        allSum += A[i];
    }
    int max = F;
    /*
      let's assume there is an array {2,3,4,6}
      first rotation = 29 allsum = 15 length is 4
      why len * A[i]? because 29 has len-1 of the last element use
      now we make it as zero anything else incresed by one
      since we do A[i]+allsum , allsum contains one of the last index so we do len*a[i]
      Since everything incresed by one,
      so all sum - one of the last index of element it equals sum of rest elements
    */
    for (int i = len-1; i>=1; i++) {
        F = F + allSum - len * A[i];
        max = Math.max(F, max);
    }
    return max;
}
