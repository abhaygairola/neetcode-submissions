class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adj.putIfAbsent(word.charAt(i), new HashSet<>());
                indegree.putIfAbsent(word.charAt(i), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int l = Math.min(s1.length(), s2.length());
            for (int j = 0; j < l; j++) {
                Character s1C= s1.charAt(j);
                Character s2C = s2.charAt(j);
                if (s1C != s2C) {
                    if(adj.get(s1C).add(s2C))
                    indegree.put(s2C, indegree.get(s2C) + 1);
                    break;
                }
                if (j == l-1 && s1.length() > s2.length())
                    return "";
            }
        }


        Queue<Character> q = new LinkedList<>();
        
        for (Character c : indegree.keySet()) {
            if(indegree.get(c)==0)
            q.add(c);
        }
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            Character c = q.poll();
            sb.append(c);
            for(Character ac :adj.get(c)){
                int in = indegree.get(ac) - 1;
                indegree.put(ac,in);
                if(in==0){
                    q.add(ac);
                }
            }
        }
        String result = sb.toString();
        
        if(result.length() != indegree.keySet().size()){return "";}
        return result;
        
        }
}
