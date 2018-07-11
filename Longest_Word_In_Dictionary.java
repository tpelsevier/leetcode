//Time O(k*n) space O(K*N)
class Solution {
    public String longestWord(String[] words) {
        Node root = buildTrie(words);
        String ans = "";
        for(String word: words) {
            Node t = root;
            boolean can = true;
            for(char c: word.toCharArray()) {
                Node n = t.children.get(c);
                if(!n.isWord) {
                    can = false;
                    break;
                }
                t = n;
            }
            if(can && word.length() >= ans.length()) {
                if(word.length() == ans.length() && word.compareTo(ans) < 0) ans = word;
                else if(word.length() > ans.length()) ans = word;
            } 
        }
        return ans;
    }
    private Node buildTrie(String[] words) {
        Node root = new Node();
        for(String word: words) {
            Node travel = root;
            for(char c: word.toCharArray()) {
                travel.children.putIfAbsent(c,new Node());
                travel = travel.children.get(c);
            }
            travel.isWord = true;
        }
        return root;
    }
    class Node {
        HashMap<Character,Node> children = new HashMap<>();
        boolean isWord = false;
    }
}
