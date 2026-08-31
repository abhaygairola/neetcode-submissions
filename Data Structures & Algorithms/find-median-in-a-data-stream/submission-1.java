class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);

        if (small.size() > large.size() + 1 || (!large.isEmpty() && small.peek() > large.peek())) {
            int temp = small.poll();
            large.offer(temp);
        }
        if (large.size() > small.size() + 1 ){
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        int s = small.size();
        int l = large.size();
        int ss = small.peek() == null ? 0 : small.peek();
        int ll = large.peek() == null ? 0 : large.peek();
        if (l == s) {
            return (ss + ll) / 2.0;
        } else if (l > s) {
            return ll;
        } else {
            return ss;
        }
    }
}
