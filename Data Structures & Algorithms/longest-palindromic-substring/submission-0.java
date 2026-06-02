class Solution {
    public String longestPalindrome(String s) {
        String pal=new String();
        int maxPal=0;
        int n= s.length();
        for(int i = 0;i<n;i++){
            int left =i;
            int right =i;
            while(left>=0 && right <n && s.charAt(left)==s.charAt(right)){
                if(maxPal<right-left+1){
                    maxPal =right-left+1;
                    pal=s.substring(left,right+1);
                }
                left--;right++;
            }
            left=i-1;
            right=i;
            while(left>=0 && right <n && s.charAt(left)==s.charAt(right)){
                if(maxPal<right-left+1){
                    maxPal =right-left+1;
                    pal=s.substring(left,right+1);
                }
                left--;right++;
            } 
        }
        return pal;
        
    }
}
