/*
    111111
    111111
   1111110
*/
//Time O(Max(a.length,b.length))
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += A[i--] - '0';
            if (j >= 0) sum += B[j--] - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
