//Time O(N^2) space O(N)
public int countSubstrings(String s) {
    int count = 0;
    for(int i = 0;i<s.length();i++){
        count +=extend(i,i,s); //Even length
        count += extend(i,i+1,s); //Odd length
    }
    return count;
}
private int extend(int s,int e, String st){
    int count = 0;
    while(s>=0 && e<st.length() && st.charAt(s) == st.charAt(e)){
        count++;
        s--;
        e++;
    }
    return count;
}
