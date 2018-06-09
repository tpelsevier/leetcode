/*
input: 一些字符串words， 一个目标字符串， 要求返回words里 包含了所有目标字符串里的所有char 的词中最短的那个。
eg:  words = [study, haha, stone, school, star, store]  target = "rts", 需要返回 的词是star, 因为star 包含了所有rts, 同时也是最短。
Source http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=400951&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
*/

public class ShortestWord{
  //Driver method
  static final String accepted = "Accepted!";
  static final String worng = "Wrong Answer! \n Correct ans is: ";
  public static void main(String[] args){
    ShortestWord sw = new ShortestWord();
    String ans = sw.shortestWord(new String[]{"study", "haha", "stone", "school", "star", "store"},"rts");
    if(!ans.equals("star")) {
      log(worng+"star");
      return;
    }
    ans = sw.shortestWord(new String[]{"looks", "pest", "stew", "show"},"s");
    if(!ans.equals("pest")){
      log(worng+"pest");
      return;
    }

    ans = sw.shortestWord(new String[]{"step", "steps", "stripe", "stepple"},"spst");
    if(!ans.equals("steps")){
      log(worng+"steps");
      return;
    }
    log(accepted);



  }
  private static void log(String output){
    System.out.println(output);
  }

  public String shortestWord(String[] words,String target){
      if(words.length == 0) return "";
      int[] count = new int[26];
      for(char c: target.toCharArray()){
        count[c-'a']++;
      }
      String ans = "";
      for(String word: words){
        int[] c2 = count.clone();
        int currCount = target.length();
        for(char c: word.toCharArray()){
          if(c2[c-'a'] >0) {
            c2[c-'a']--;
            currCount--;
          }
          if(currCount == 0) break;
        }
        if(currCount == 0 && (ans.equals("") || word.length() < ans.length())) ans = word;
      }
      return ans;
  }

}
