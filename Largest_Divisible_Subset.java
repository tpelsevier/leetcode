//Time O(N^2) space O(N);
/*
      1,2,3,4,5
Prev -1,0,0,1,0
count 1,2,2,3,2
*/
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        if(nums.length == 0 || nums == null) return ls;
        int n = nums.length;
        int[] pre = new int[n]; //Stores previous previous link position
        int[] counts = new int[n]; //Store count of elements of the subset
        int index = -1; //Initial the index as -1
        Arrays.sort(nums); //sort the array if b > a, c > b  if b%a == 0  and c % b == 0 then c % a == 0
        for(int i = 0;i<n;i++){
            pre[i] = -1;//Initial the pre link to -1
            counts[i] = 1; //Counts in current pos is 1
            for(int j = i-1;j>=0;j--){
                if(nums[i] % nums[j] == 0){
                    if(counts[j] +1 > counts[i]){ //If count j +1 is greater than count count[i]
                        counts[i] = counts[j] + 1; //Count will plus one since it plus it self
                        pre[i] = j;//Prev index of current pos will be j
                    }
                }
            }
            if(index == -1 || counts[i] > counts[index]) index = i;
        }
        //Then generate the array list
        while(index != -1){
            ls.add(nums[index]);
            index = pre[index];
        }
        return ls;
    }
}
