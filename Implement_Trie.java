//Time for search O(M)
class Trie {

    /** Initialize your data structure here. */
    Node root;
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node T = root;
        for(char c: word.toCharArray()){
            if(T.n[c-'a'] == null) T.n[c-'a'] = new Node();
            T = T.n[c-'a'];
            T.isPrefix = true;
        }
        T.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node T = root;
        for(char c: word.toCharArray()){
            if(T.n[c-'a'] == null) return false;
            T = T.n[c-'a'];
        }
        return T.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node T = root;
        for(char c: prefix.toCharArray()){
            if(T.n[c-'a'] == null) return false;
            T = T.n[c-'a'];
        }
        return T.isPrefix;
    }
    class Node{
        Node[] n;
        boolean isWord = false;
        boolean isPrefix = false;
        public Node() {
            n = new Node[26];
        }
    }
}
