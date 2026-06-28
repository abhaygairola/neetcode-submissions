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

                for (int i = 0; i < cur.length(); i++) {
                    for (int j = 0; j <= 26; j++) {
                        char[] temp = cur.toCharArray();
                        temp[i] = (char)((int)'a' + j);
                        String tempStr = new String(temp);
                        if (words.contains(tempStr)) {
                            if (tempStr.equals(endWord))
                                return level + 1;
                            pq.add(tempStr);
                            words.remove(tempStr);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
