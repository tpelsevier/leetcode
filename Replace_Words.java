class Solution {
    Node root = new Node();
    public String replaceWords(List<String> dict, String sentence) {
        for(String s: dict) buildTrie(s); //Build trie first
        StringBuilder sb = new StringBuilder();
        outer:for(String s: sentence.split(" ")){
            Node t = root;
            for(Character c: s.toCharArray()){
                if(t.cs[c-'a'] == null){
                  //if the node does not existed, check if it is a word or Not
                  //if it is not a word, append the original word
                  //else append the word store in the node
                    if(!t.isWord) sb.append(s+" ");
                    else sb.append(t.word+" ");
                    continue outer;
                }
                else{
                    t = t.cs[c-'a'];
                    if(t.isWord) break;
                }
            }
            //If current node is a word, append the word else append the original word
            if(t.isWord) sb.append(t.word+" ");
            else sb.append(s+" ");
        }
        return sb.toString().trim();
    }
    private void buildTrie(String s){
        Node t = root;
        for(Character c: s.toCharArray()){
            if(t.cs[c-'a'] == null) t.cs[c-'a'] = new Node();
            t = t.cs[c-'a'];
        }
        t.isWord = true;
        t.word = s;
    }
    class Node{
        Node[] cs = new Node[26];
        Boolean isWord = false;
        String word = "";
    }
}
