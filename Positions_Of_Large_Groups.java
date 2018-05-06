//Time O(N) Space O(1)
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < S.length()-1;i++){
            char c = S.charAt(i);
            int j = i;
            while(j < S.length() && S.charAt(j) == c) j++;
            //Since current j is not equals to c, so decrease by one
            if(j-i >= 3) res.add(new ArrayList<>(Arrays.asList(i,--j)));
            i = j-1; //Since i++ will increase one
        }
        return res;
    }
}
