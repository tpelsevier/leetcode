//Time ? Space ?
public String fractionToDecimal(int numerator, int denominator) {
    if(numerator == 0) return "0";
    StringBuilder sb = new StringBuilder((numerator > 0) ^ (denominator > 0)?"-":"");
    long num = Math.abs((long)numerator);
    long den = Math.abs((long)denominator);
    //Since long is a float point data type
    //If num < den then 0.is append to the string.
    sb.append(num/den);
    num%=den;//We need to get the remaining and do the calculation again
    if(num == 0) return sb.toString();
    sb.append(".");
    HashMap<Long,Integer> map = new HashMap<>();
    map.put(num,sb.length());//Store the remaining in the hashmap and the curr index
    while(num != 0){
        num*=10; //We need to borrow a 10 to do a calculation
        sb.append(num/den);
        num%=den;
        if(map.containsKey(num)){
            sb.insert(map.get(num),"(");
            sb.append(")");//Because if it appears again,
            break;
        }else{
            map.put(num,sb.length());
        }
    }
    return sb.toString();
}
