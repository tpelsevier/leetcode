//Time O(N) Space O(1)
class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String extra = "maa";
        for(int i = 0; i < words.length;i++){
            if(words[i].charAt(0) == 'a' || words[i].charAt(0) == 'e' || words[i].charAt(0) == 'i'||words[i].charAt(0) == 'o'||words[i].charAt(0) == 'u'||
               words[i].charAt(0) == 'A' || words[i].charAt(0) == 'E' || words[i].charAt(0) == 'I'||words[i].charAt(0) == 'O'||words[i].charAt(0) == 'U'){
               words[i] = words[i]+extra;
            }else{
                words[i] = words[i].substring(1,words[i].length())+words[i].charAt(0)+extra;
            }
            extra+="a";
        }
        return String.join(" ",words);
    }
}
