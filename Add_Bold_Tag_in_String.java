//Time ((N*M) + N) Space O(N)
class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(int start = 0, end = 0; start < s.length();start ++){
            for(String str: dict){
              // check if any word starts in position start
              //If yes , compare the current end position to the start position plus the string leng
                if(s.startsWith(str,start)) end = Math.max(end,start+str.length());
            }
            bold[start] = end > start;//If the end is greater then start, then it is in the range of bold
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();i++){
            if(!bold[i]){
                sb.append(s.charAt(i));
                continue;
            }
            int j = i;
            //Find the bold tag end point
            while(j<s.length() && bold[j])j++;
            sb.append("<b>"+s.substring(i,j)+"</b>");
            i = j-1;
        }
        return sb.toString();
    }
}
