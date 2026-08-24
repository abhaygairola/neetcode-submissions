class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> map;
    Node left;
    Node right;

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node() {}
        Node(int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        left = null;
        right = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node res = map.get(key);
        if (res == null)
            return -1;
        remove(res);
        if (this.left == null) {
            left = res;
        }
        if (this.right != null)
            right.next = res;
        res.prev = right;
        right = res;
        return res.value;
    }

    public void put(int key, int value) {
        Node res;
        if (map.containsKey(key)) {
            res = map.get(key);
            res.value = value;
            remove(res);
            if (this.left == null) {
                left = res;
            }
            if (this.right != null)
                right.next = res;
            res.prev = right;
            right = res;

        } else {
            if (this.size + 1 > this.capacity) {
                map.remove(this.left.key);
                remove(this.left);
                size--;
            }
            res = new Node(key, value, null, null);
            if (this.left == null) {
                left = res;
            }
            if (this.right != null)
                right.next = res;
            res.prev = right;
            right = res;
            size++;
            map.put(key, res);
        }
    }

    private void remove(Node rem) {
        Node l = rem.prev;
        Node r = rem.next;
        if (l != null)
            l.next = r;
        if (r != null)
            r.prev = l;
        if (this.left == rem) {
            this.left = r;
        }
        if (this.right == rem) {
            this.right = l;
        }
        rem.prev = null;
        rem.next = null;
    }
}
