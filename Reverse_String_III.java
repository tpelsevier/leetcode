//Time O(N) Space O(N)
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(start + k - 1, s.length() - 1); //To see if the end point is beyond the string length
            while (start < end) {
                char temp = ch[start];
                ch[start ++] = ch[end];
                ch[end --] = temp;
            }
        }
        return new String(ch);
    }
}
