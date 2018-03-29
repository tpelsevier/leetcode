/*
length = 5,
updates = [
    [1,  3,  2],
    [2,  4,  3],
    [0,  2, -2]
]

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]

Assume there is only one operation
[0,2,0,0,-2]
so after the second for loop
[0,2,2,2,0]
*/


//Time O(N+K) Space O(1)
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] u: updates){
            res[u[0]]+=u[2];
            if(u[1] +1 < length) res[u[1]+1] -=u[2];
        }
        for(int i =1;i<length;i++){
            res[i] += res[i-1];
        }
        return res;
    }
}
