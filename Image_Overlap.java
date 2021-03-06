//Time O(N^3) Space O(N^2)
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N * N; ++i) {
            //Find the pos that is equal to one
            if (A[i / N][i % N] == 1) LA.add(i / N * 100 + i % N);
            if (B[i / N][i % N] == 1) LB.add(i / N * 100 + i % N);
        }
        for (int i : LA) {
          for (int j : LB)
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        }
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;
    }
}
//Time O(N^4) Space O(N^2)

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                              /*Add up the other overlap area that has
                              same move 
                              */
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }
}
