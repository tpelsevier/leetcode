//Time O(N) sPACE O(N)
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        if(A.equals(B)){
            HashSet<Character> set = new HashSet<>();
            for(char c: A.toCharArray()) set.add(c);
            return set.size() < A.length();
        }
        int count = 0, j = 0;
        int[] diff = new int[2];
        for(int i = 0; i < A.length();i++){
            if(A.charAt(i) != B.charAt(i)){
                count++;
                if(count > 2) return false;
                diff[j++] = i;
            }
        }
        return count == 2 && A.charAt(diff[0]) == B.charAt(diff[1]) && A.charAt(diff[1]) == B.charAt(diff[0]);

    }
}
