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
        int start =0; 
        int end=-1;
        int curLen =0;
        int cnt =0;
        while(end<len-1){
        start = str.indexOf('#',end+1)+1;
        curLen = Integer.parseInt(str.substring(end+1,start-1));
        end = start+curLen-1;
        res.add(str.substring(start,end+1));
        cnt++;
        }
        return res;


    }
}
