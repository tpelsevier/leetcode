//Time O(N*(N/10)) Space O(1)

//1 0 8 STAYS THE SAME WHEN ROTATED 180 degree
class Solution {
    public int rotatedDigits(int N) {
        if(N < 2) return 0;
        int count = 0;
        for(int i = 2; i<=N;i++){
            if(valid(i)) count++;
        }
        return count;
    }
    private boolean valid(int n){

        boolean valid = false;
        while(n > 0){
            if(n%10 == 2) valid = true;
            if(n%10 == 5) valid = true;
            if(n%10 == 6) valid = true;
            if(n%10 == 9) valid = true;
            if(n%10 == 3) return false;
            if(n%10 == 4) return false;
            if(n%10 == 7) return false;
            n/=10;
        }
        return valid;
    }
}
