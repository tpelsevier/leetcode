//Time O(N+M) Space(N+M)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2=nums2.length;
        if(l1 == 0 && l2 == 0) return 0;
        int i = 0, j = 0,k = 0;
        int[] res = new int[l1+l2];
        while(i < l1 || j < l2){
            if(i>=l1) res[k++] = nums2[j++];
            else if(j>=l2) res[k++] = nums1[i++];
            else{
                if(nums1[i] > nums2[j]) res[k++]=nums2[j++];
                else res[k++] = nums1[i++];
            }
        }
        return res.length%2 == 0 ?(res[res.length/2-1]+res[res.length/2] + 0.0)/2:res[res.length/2];
    }
}
//Time O((M+N)/2) Space O(M+N)
class Solution {
  //Use less space
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2=nums2.length;
        if(l1 == 0 && l2 == 0) return 0;
        int i = 0, j = 0,k = 0;
        int[] res = new int[(l1+l2)/2+1];
        while(k<res.length){
            if(i>=l1) res[k++] = nums2[j++];
            else if(j>=l2) res[k++] = nums1[i++];
            else{
                if(nums1[i] > nums2[j]) res[k++]=nums2[j++];
                else res[k++] = nums1[i++];
            }
        }
        return  ((l1+l2)%2 == 0)? (res[res.length-1]+res[res.length-2] + 0.0)/2:res[res.length-1];
    }
}


//Time O(Min(M,N)) Space O(1)
//Find the left index of mid point and right index of mid point for both number
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) {
            return findMedianSortedArrays(nums2,nums1);
        }
        if(n1 == 0) return (n2%2==0)?(double)(nums2[n2/2]+nums2[(n2/2)-1])/2 : nums2[n2/2];

        int l=0,r=n1;
        while(l<=r) {
            int partX = (l+r)/2,
            partY=((n1+n2+1)/2)-partX;
            int leftX = (partX==0)?Integer.MIN_VALUE:nums1[partX-1];
            int rightX = (partX==n1)?Integer.MAX_VALUE:nums1[partX];
            int leftY = (partY==0)?Integer.MIN_VALUE:nums2[partY-1];
            int rightY = (partY==n2)?Integer.MAX_VALUE:nums2[partY];

            if(leftX <= rightY && leftY <= rightX) {
               if((n1+n2) % 2 == 0) {
                    int res = Math.max(leftX,leftY);
                    res+=Math.min(rightX,rightY);
                    return (double)res/2;
                }
                else
                    return Math.max(leftX,leftY);
            } else if(leftX > rightY) {
                r=partX-1;
            } else
                l=partX+1;
        }
       return -1;
    }
}
