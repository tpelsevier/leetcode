//Time O(N) Space O(N)
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.equals(B)) return true;
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0;i<A.length();i++){
            String c = sb.append(A.charAt(i)).deleteCharAt(0).toString();
            if(c.equals(B)) return true;
        }
        return false;
    }
}
//Time O(1) Space O(N)
class Solution {
    public boolean rotateString(String A, String B) {
        String c = A+A;
        return c.contains(B);
    }
}
