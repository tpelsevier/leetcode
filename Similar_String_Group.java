//Time O(N^2) Space O(1)
//DFS Solution
class Solution {
    public int numSimilarGroups(String[] A) {
        int count = 0;
        for(int i = 0; i < A.length;i++){
            if(A[i] == null) continue;
            count++; //Add one more group to it.
            String word = A[i];
            A[i] = null;
            dfs(word,A);
        }

        return count;
    }
    private void dfs(String word, String[] A){
        for(int i = 0; i < A.length;i++){
            if(A[i] == null) continue;
            if(isValid(word,A[i])){
                String next = A[i];
                A[i] = null;
                dfs(next,A);
            }
        }
    }
    private boolean isValid(String word, String word2){
        int res = 0, i = 0, wordTotal = 0, word2Total = 0;
        while(i < word.length() && res <= 2){
            char c1 = word.charAt(i), c2 = word2.charAt(i);
            if(c1 != c2) res++;
            wordTotal+= (int)c1;
            word2Total+=(int)c2;
            i++;
        }
        return res == 2 && word2Total == wordTotal;
    }
}
