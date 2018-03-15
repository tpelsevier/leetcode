//Time O(NlogN) Space O(N)
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        s = new String(cs);
        t = new String(ct);
        return s.equals(t);
    }
}
//Time O(N) Space O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] co = new int[26];
        for(Character c: s.toCharArray()) co[c-'a'] ++;
        for(Character c: t.toCharArray()) co[c-'a']--;
        for(int i: co){
            if(i != 0) return false;
        }
        return true;
    }
}
