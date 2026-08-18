class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        int n = heights.length;

        for (int r = 0; r <= n; r++) {
            while (!stack.isEmpty() && (r==n || heights[stack.peek()]>=heights[r])) {
                int h = heights[stack.pop()];
                int l = !stack.isEmpty()?stack.peek():-1;
                
                maxArea=Math.max(maxArea,(r-l-1)*h);
                
                
            }
            stack.push(r);
        }
        return maxArea;
    }
}
