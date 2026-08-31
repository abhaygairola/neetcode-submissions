class KthLargest {
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
        }
        while (q.size() > k) {
            q.poll();
        }
        
    }

    public int add(int val) {
        q.offer(val);
        while (q.size() >k) {
            q.poll();
        }        
        return q.peek();
    }
}
