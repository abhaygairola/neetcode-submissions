class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> result = new HashMap<>();

        for(String s : strs){
            int[]freq = new int[26];
            char[]car = s.toCharArray();
            for(char c:car){
                freq[c-'a']++;
            }
            String k = Arrays.toString(freq);
            result.putIfAbsent(k,new ArrayList<>());
            List<String> a = result.get(k);
            a.add(s);
            result.put(k,a);
        }

        return new ArrayList<>(result.values());
        
    }
}
