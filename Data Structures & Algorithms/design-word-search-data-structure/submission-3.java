class WordDictionary {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end = false;
        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode cur) {
        if (word.length() == 0) {
            return cur.end;
        }
        char cc = word.charAt(0);
        if (cc == '.') {
            for (Character c : cur.children.keySet()) {
                if (search(word.substring(1), cur.children.get(c))) {
                    return true;
                }
            }
            return false;
        } else {
            if (!cur.children.containsKey(cc)) {
                return false;
            }
            return search(word.substring(1), cur.children.get(cc));
        }
    }
}
