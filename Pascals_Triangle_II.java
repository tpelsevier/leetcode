//Time O(N^2) Space O(N)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) return new ArrayList<>(Arrays.asList(1));
        List<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(1);
        for(int i = 1; i < rowIndex;i++){
            row.add(0,1);
            for(int j = 1; j < row.size()-1;j++) row.set(j,row.get(j)+row.get(j+1));
        }
        return row;
    }
}
