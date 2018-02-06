//Time O(N) Space O(N)
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ",sentence)+" "; //Combine sentence into one string O(N)
        int p = 0,l = s.length();
        for(int i = 0;i<rows;i++){
            p+=cols;
            if(s.charAt(p%l) == ' ') p++; 
            else while(p > 0 && s.charAt((p-1)%l) != ' ') p --; //Find the index of the string which equals ' '
        }
        return p / s.length();
    }
}
