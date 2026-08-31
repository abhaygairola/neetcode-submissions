class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> Integer.compare(
            (int)Math.pow(b[0], 2) + (int)Math.pow(b[1], 2), (int)Math.pow(a[0], 2) + (int)Math.pow(a[1], 2)));
        int[][] res = new int[k][2];

        for (int[] a : points) {
            q.offer(a);
            if (q.size() > k) {
                q.poll();
            }
        }
        int n =q.size();
        for (int i = 0; i <n ; i++) {
            int[] a = q.poll();
            res[i][0] = a[0];
            res[i][1] = a[1];
        }
        return res;
    }
}
