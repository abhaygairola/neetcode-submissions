class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : stones) {
            q.offer(i);
        }
        while (q.size()>1){
            int l = q.poll();
            int sl = q.poll();
            int val = l-sl;
            if(val>0){q.offer(val);}
        }
        return q.peek()==null? 0:q.peek();

        }
}
