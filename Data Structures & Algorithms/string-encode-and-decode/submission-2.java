class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int len = str.length();
        int i =0;
        while(i<len){
            int j =i;
            while(str.charAt(j)!='#')
            {j++;}
            int curLen = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+curLen;
            res.add(str.substring(i,j));
            i=j;
        }
        return res;


    }
}
