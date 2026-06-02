class Solution {
    public int numDecodings(String s) {

        int prev=s.charAt(0)=='0'?0:1;
        int prev2=1;
        int temp=0;
        for (int i=1;i<s.length();i++){
            temp=0;
            if(s.charAt(i)>'0')temp+= prev;
            if(s.charAt(i-1) == '1' ||
               (s.charAt(i-1) == '2' && s.charAt(i) < '7')) temp+= prev2;
            prev2=prev;
            prev=temp;            
        }
        return prev;

        
    }
}
