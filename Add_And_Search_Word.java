//Time O(nl) l = s.length N inputs Space O(C*NODES) where c = number of nodes
class WordDictionary {

    /** Initialize your data structure here. */
    Node head;
    public WordDictionary() {
        head = new Node();
    }
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node t = head;
        for(char c:word.toCharArray()){
            if(t.nodes[c-'a'] == null) t.nodes[c-'a'] = new Node();
            t = t.nodes[c-'a'];
        }
        t.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word,head,0);
    }
    public boolean find(String word, Node root,int index){
        if(index == word.length()) return root.isWord;
        if(word.charAt(index) == '.'){
            for(Node n: root.nodes){
                if(n != null && find(word,n,index+1)) return true;
            }
            return false;
        }
        Node temp = root.nodes[word.charAt(index) - 'a'];
        if(temp == null) return false;
        return find(word,temp,index+1);
    }
    class Node{
        Node [] nodes;
        boolean isWord; //Verify if this is a word
        public Node(){
            nodes = new Node[26];
            isWord = false;
        }
    }
}
