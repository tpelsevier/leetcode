//Time O(N*M) N = words.size() M = individual word.length Space O(M*N)
class Solution {
    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        char[][] graph = new char[size][];
        for(int i = 0; i < size;i++){
            String word = words.get(i);
            if(word.length() > size) return false;
            graph[i] = word.toCharArray();
        }
        for(int i = 0; i < size;i++){
            for(int j = 0; j < graph[i].length;j++){
                if(i >= graph[j].length || graph[i][j] != graph[j][i]) return false;
            }
        }
        return true;
    }
}
