//Time O(NlogN) Space O(N)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        //We need to research k element at end 
        int lo = 0, high = arr.length - k;
        while(lo < high){
            int mid = (lo+high)/2;
            //if x - arr[mid] is a negative, the left part is what we want because x < arr[mid]
            //if x - arr[mid] == arr[mid+k] - we want the smaller one
            if(x- arr[mid] > arr[mid+k] - x) lo = mid+1;
            else high = mid;
        }
        while(k-- > 0) res.add(arr[lo++]);
        return res;
    }
}
