/*
黑盒子里9个球（程序要能扩展到n个球的情况，n是3的倍数），RGB三种不同颜色，每种颜色各有三个球
两个函数：GetColor（i），Swap（i，j）
RRBGRBGBG => RGBRGBRGB
时间复杂度和空间复杂度尽可能低（请指明所写代码的时间和空间复杂度
*/
class Three_Colors_Sort{
  public static void main(String[] args){

  }
  public String sortColor(String s){
      char[] colors = s.toCharArray();
      int len = colors.length;
      char[] pattern = new char[]{'R','G','B'};
      int patternIndex = 2;
      for(int i = 0; i < colors.length;i++){
          if(++patternIndex > 2) patternIndex = 0;
          char color = pattern[patternIndex];
          if(colors[i] == color) continue;
          else{
              int j = i+1;
              while(colors[j] != color) j++;
              swap(i,j,colors);
          }
      }
      return new String(colors);
  }
  private void swap(int i, int j, char[] colors){
      char temp = colors[i];
      colors[i] = colors[j];
      colors[j] = temp;
  }
}
