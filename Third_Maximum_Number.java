//Time O(N) O(1)
class Solution {
    public int thirdMax(int[] nums) {
        Integer m1 = null,m2=null,m3=null; // Initialized all three value == null
        for(int n: nums){
            if((m1 != null && n == m1)||(m2 != null && n == m2)||(m3 != null && n == m3)) continue;
            if(m1 == null || n > m1){
                m3 = m2;
                m2 = m1;
                m1 = n;
            }
            else if (m2 == null || n > m2){
                m3 = m2;
                m2 = n;
            }
            else if (m3 == null || n > m3) m3 = n;
        }
        return m3 == null? m1:m3; //If the third maxium number == null then reqturn the maxium
    }
}
