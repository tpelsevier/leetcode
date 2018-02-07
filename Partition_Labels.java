//Time O(N) Space O(1)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ls = new ArrayList<>();
        int s = 0,f=S.lastIndexOf(S.charAt(s)); //find the last index of the current char
        for(int i =0;i<S.length();i++){
            if(i == f){ //if travel pointer i == last index means it reach the end of the partition
                ls.add(f-s+1);
                if(i != S.length()-1){ //if it is not the last index then starter pointer equals to travel pointer +1
                    s = i+1;
                    f = S.lastIndexOf(S.charAt(s)); //Find the last index of the new starter point
                }
            }else{
                f = Math.max(f,S.lastIndexOf(S.charAt(i))); //find the last index of the new char
            }
        }
        return ls;
    }
}
