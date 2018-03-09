
//Time O(N) Space O(N)
class Solution {
    public int calPoints(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for(String op: ops){
            switch (op){
                case "+":
                   //Add last two round
                    list.add(list.peekLast()+list.get(list.size()-2));
                    sum+=list.peekLast();
                    break;
                case "C":
                   //Remove last valid round
                    sum-= list.removeLast();
                    break;
                case "D":
                   //Double last valid round
                    list.add(list.peekLast()*2);
                    sum+=list.peekLast();
                    break;
                default:
                  //Default number is Integer.
                    list.add(Integer.parseInt(op));
                    sum+= list.peekLast();
                    break;

            }
        }
        return sum;
    }
}
