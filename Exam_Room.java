import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// fib3: 1 1 1 3 5 9 17 31...

// fib3(0) = 1
// fib3(1) = 1
// fib3(2) = 1
// fib3(3) = 3

/*
With 8 seats:
_    _    _    _    _    _    _    _
0 .  1 .  2 .  3 .  4 .  5 .  6 .  7

add("s1") -> 0
"s1" _    _    _    _    _    _    _
add("s2") -> 7
"s1" _    _    _    _    _    _    "s2"
add("s3") -> 3
"s1" _    _    "s3" _    _    _    "s2"
add("s4") -> 5
"s1" _    _    "s3" _    "s4" _    "s2"
remove("s3")
"s1" _    _    _ .  _    "s4" _    "s2"
add("s5") -> 2
"s1" _    "s5" _ .  _    "s4" _    "s2"



add(student_id) ---> seat #
remove(student_id)
*/

class Solution {
  public static void main(String[] args) {
    Room r = new Room(8);
    System.out.println(r.add("s1"));
    System.out.println(r.add("s2"));
    System.out.println(r.add("s3"));
    System.out.println(r.add("s4"));
    r.remove("s3");
    System.out.println(r.add("s5"));
  }
  static class Room{
    HashMap<String,Integer> map = new HashMap<>();
    boolean[] seats;
    int n;
    public Room(int n){
      this.n = n;
      seats = new boolean[n];
    }
    private int add(String id){
      if(map.isEmpty()){
          seats[0] = true;
          map.put(id,0);
          return 0;
      }
      int max = 0;
      int seatN = -1;
      for(int i = 0;i < n; i++){
         if((i == 0 && !seats[0]) || seats[i]){
          int j = i;
           System.out.println(i + " "+j);
            if(i - j -1 > max){
              max = i-j-1;
              seatN = (i+j)/2;

         }
        if(i == n) break;
      }
      map.put(id,seatN);
      seats[seatN] = true;
      return seatN;
    }
    private void remove(String id){
        if(map.containsKey(id)){
          seats[map.get(id)] = false;
          map.remove(id);
        }
    }
  }
}
