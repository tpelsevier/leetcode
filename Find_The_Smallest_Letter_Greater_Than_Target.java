//Time O(Log N) Space O(1)
class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      if(letters[letters.length-1] <= target) return letters[0];
      int low = 0, high = letters.length-1;
      while(low < high){
          int mid = low + (high-low)/2;
          if(letters[mid] > target) high = mid;
          else low = mid+1;
      }
      return letters[low];
  }
}
