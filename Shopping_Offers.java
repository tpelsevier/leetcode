//Time O(N^2) space O(N)
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return helper(price,special,needs,0);
    }
    private int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int curr_min = justBuy(price,needs);
        for(int i = pos;i < special.size();i++){
            List<Integer> offer = special.get(i);
            List<Integer> next_need = new ArrayList<>();
            for(int j =0;j<needs.size();j++){
                int n = needs.get(j);
                int o = offer.get(j);
                if(n < o){ //If needs bigger than what offer has, means this offer is invalid
                    next_need = null;
                    break;
                }
                next_need.add(n - o);//else add to the next need to see how many do we need after this offer
            }
            if(next_need != null){
                //Current offer can be used, but we need to see how much we need.
                curr_min = Math.min(curr_min, offer.get(offer.size()-1)+helper(price,special,next_need,i));
            }
        }

        return curr_min;
    }
    private int justBuy(List<Integer> price,List<Integer> needs){
        int sum = 0;
        for(int i = 0; i<price.size();i++){
            sum += needs.get(i) * price.get(i);
        }
        return sum;
    }
}
