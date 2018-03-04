class MagicDictionary {

    /** Initialize your data structure here. */
    Node root;
    public MagicDictionary() {
        root = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict){
            Node T = root;
            for(Character c: s.toCharArray()){
                if(T.cs[c-'a'] == null) T.cs[c-'a'] = new Node();
                T = T.cs[c-'a'];
            }
            T.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for(int i = 0;i<word.length();i++){
            for(char c = 'a'; c<'z';c++){
              // if c equals to the char at this index
                if(c == word.charAt(i) ) continue;
                char ori = arr[i];
                arr[i] = c; //change char in that position to c
                if(skip(new String(arr))) return true;
                arr[i] = ori; //Change it back
            }
        }
        return false;
    }
    private boolean skip(String word){
        Node t = root;
        for(Character c: word.toCharArray()){
            if(t.cs[c-'a'] == null) return false;
            else t = t.cs[c-'a'];
        }
        return t.isWord;
    }

    class Node{
        Node[] cs;
        boolean isWord = false;
        public Node() {cs = new Node[26];}
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
