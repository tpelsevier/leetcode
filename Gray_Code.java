//Time O(N) Space O(1)
//G(X) = X ^(X/2)

/*
  n = 2
  i < 4
  i = 0
      00
      00
 res= 0
 i = 1
     01
     00
res= 1
i = 2
    10
    01
res= 3
i = 3
    11
    01
res= 2

*/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ls = new ArrayList<>(0);
        for(int i = 0; i< 1<<n;i++) ls.add(i^i>>1);
        return ls;
    }
}
