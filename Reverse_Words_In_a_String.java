//Time (OLogN) Space O(N)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String ss: s.split(" ")){
            sb.append(new StringBuilder(ss).reverse()).append(" ");
        }
        return sb.toString().trim();
    }
}
