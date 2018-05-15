//Time O(N) Space O(1)
class Solution {
    public String maskPII(String S) {
        int index = S.indexOf("@"); //Finding index is O(N)
        if(index >= 0){
            return (S.charAt(0) +"*****"+S.substring(index-1)).toLowerCase();
        }else{
            String digits = S.replaceAll("\\D+","");
            String local = "***-***-"+digits.substring(digits.length()-4);
            if(digits.length() == 10) return local;
            String ans = "+";
            for(int i = 0; i < digits.length() - 10; i++) ans+="*";
            return ans+"-"+local;
        }
    }

}
