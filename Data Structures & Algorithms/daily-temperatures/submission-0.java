class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int res[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int rem[] = stack.pop();
                res[rem[1]] = i-rem[1];
            }
            stack.push(new int[] {temperatures[i], i});
        }
        return res;
    }
}
