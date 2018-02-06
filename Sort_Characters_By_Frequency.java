//Time N(NLOGN) space(N);
class Solution {
    public String frequencySort(String s) {
        int[] counts = new int[256];
        char[] cs = s.toCharArray();
        for(char c:cs) counts[c] ++; // Get count of each Character
        Map<Integer,ArrayList<Character>> map = new HashMap<>();
        for(int i = 0;i<counts.length;i++){ //Arrange a hashmap for each count number
            if(counts[i] == 0) continue;
            if(!map.containsKey(counts[i])) map.put(counts[i],new ArrayList<>());
            map.get(counts[i]).add((char)i);
        }
        Arrays.sort(counts); //Sort the counts inorder for map to get it N(Nlogn)
        StringBuilder sb = new StringBuilder();
        for(int i = counts.length-1;i>=0;i--){
            if(counts[i] == 0) break;
            ArrayList<Character> cls = map.get(counts[i]); //Get the ArrayList
            if(cls == null) continue; //Since two character has same count sometimes, but we remove the count from the hashmap
            for(Character c: cls){
                for(int j = 0;j<counts[i];j++)sb.append(c);
            }
            map.remove(counts[i]);//Remove the count from the hashmap
        }
        return sb.toString();
    }
}
