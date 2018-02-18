//Time O(L) l = string length Space O(26*L)
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0 || words.length == 0 || words == null) return res;
        Node r = new Node();
        for(String word:words){
            Node t = r;
            for(char c: word.toCharArray()){
                if(t.cs[c-'a'] == null) t.cs[c-'a'] = new Node();
                t = t.cs[c-'a'];
            }
            t.word = word;
        }
        int m = board.length,n = board[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                DFS(board,i,j,r);
            }
        }
        return res;
    }
    private void DFS(char[][] b,int i,int j,Node root){
        if(root.word != null){ //If there contains this word
            res.add(root.word);
            root.word = null; //Mark as null in case of duplicated
            return;
        }
        if(i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] == '#' ||root.cs[b[i][j]-'a'] == null) return;
        char c = b[i][j];
        b[i][j] = '#'; //Mark as visted
        DFS(b,i+1,j,root.cs[c-'a']);
        DFS(b,i-1,j,root.cs[c-'a']);
        DFS(b,i,j+1,root.cs[c-'a']);
        DFS(b,i,j-1,root.cs[c-'a']);
        b[i][j] = c; //Mark it back

    }


    class Node{
        Node[] cs;
        String word;
        public Node(){
            cs = new Node[26];
        }
    }
}
