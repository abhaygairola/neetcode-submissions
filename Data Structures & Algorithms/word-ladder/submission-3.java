class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;
        Queue<String> pq = new LinkedList<>();
        int level = 1;

        pq.add(beginWord);

        while (!pq.isEmpty()) {
            int s =pq.size();
            for (int l = 0; l <s ; l++) {
                String cur = pq.poll();
                char[] temp = cur.toCharArray();
                //finding adjacent by every character
                for (int i = 0; i < cur.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char t = temp[i];               
                        temp[i] = c;
                        String tempStr = new String(temp);
                        if (words.contains(tempStr)) {
                            if (tempStr.equals(endWord))
                                return level + 1;
                            pq.add(tempStr);
                            words.remove(tempStr); // remove word on finding so shortest distance
                        }
                        temp[i] = t;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
