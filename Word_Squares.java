//Time O(26^(N^2)) Space O(K*L^2)
class Solution {
    Node root = new Node();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> wordSquares(String[] words) {
        buildTrie(words);
        Node[] rows = new Node[words[0].length()];
        Arrays.fill(rows,root);
        helper(0,0,rows);
        return res;
    }
    private void helper(int row, int col,Node[] rows){
        if(row == rows.length){
            List<String> temp = new ArrayList<>(rows.length);
            for(Node r: rows) temp.add(r.word);
            res.add(temp);
            return;
        }else if(col < rows.length){
            Node currow = rows[row];
            Node curcol = rows[col];
            for(int i = 0; i < 26;i++){
                if(currow.cs[i] != null && curcol.cs[i] != null){
                  //If the rows[row] position has value in children as i
                  //Move to the children node same as col
                    rows[row] = currow.cs[i];
                    rows[col] = curcol.cs[i];
                    //Use a new node for col, since moving in the same row
                    helper(row,col+1,rows);
                }
            }
            rows[row] = currow;
            rows[col] = curcol;
        }else{
            //since it went diagonllly, the row and col always stays the same
            helper(row+1,row+1,rows);
        }
    }
    private void buildTrie(String[] words){
        for(String word: words){
            Node t = root;
            for(char c: word.toCharArray()){
                if(t.cs[c-'a'] == null) t.cs[c-'a'] = new Node();
                t = t.cs[c-'a'];
            }
            t.word = word;
        }
    }
    class Node{
        Node[] cs = new Node[26];
        String word = "";
    }
}
