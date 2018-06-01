//Time O(N*M) Space O(N)
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String path: paths){
            int first = path.indexOf("(");
            while(path.charAt(first) != ' ') first--;
            String dir = path.substring(0,first);  //Find the root directory
            parsing(dir,path.substring(first+1),map);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> ls: map.values()){
            if(ls.size() > 1) { //Only if there is a duplicate
                res.add(ls);
            }
        }
        return res;
    }
    private void parsing(String dir, String sub, HashMap<String,List<String>> map){
        int index = sub.indexOf("(");
        if(index == -1) return;
        String file = sub.substring(0,index);
        int index2 = sub.indexOf(")");
        String content = sub.substring(index+1,index2);
        if(!map.containsKey(content)) map.put(content,new ArrayList<>());
        map.get(content).add(dir+"/"+file);
        if(index2 == sub.length()-1) return; // If the close parenthese = -1 means it reached the end
        parsing(dir,sub.substring(index2+2),map); // other wise keep parsing
    }
}
