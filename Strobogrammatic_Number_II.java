//Time O(N^2) Space O(N)
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return backTracking(n,n);
    }
    private List<String> backTracking(int n,int m){
        if(n == 0) return new ArrayList<>(Arrays.asList(""));
        if(n == 1) return new ArrayList<>(Arrays.asList("0","1","8"));
        List<String> samples = backTracking(n-2,n); //Keep reducing
        List<String> res = new ArrayList<>();
        for(String s: samples){
            if(m != n){
                res.add("0" + s +"0"); // Since 010 or 080 is ivalid
            }
            res.add("1" + s + "1"); //11 111 101 181
            res.add("6" + s + "9"); // 69 609 619 689
            res.add("8" + s + "8"); // 88 808 818 888
            res.add("9" + s + "6"); // 96 906 916 986
        }

        return res; // Then return the result
    }
}
