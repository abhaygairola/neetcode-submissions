class Solution {
    public int numDecodings(String s) {

        int prev=s.charAt(0)=='0'?0:1;
        int prev2=1;
        for (int i=1;i<s.length();i++){
            int temp=0;
            if(s.charAt(i)>'0')temp+= prev;
            int x = Integer.parseInt(s.substring(i-1,i+1));
            if(x>=10 &&x<=26) temp+= prev2;
            prev2=prev;
            prev=temp;
            
        }
        return prev;

        
    }
}
