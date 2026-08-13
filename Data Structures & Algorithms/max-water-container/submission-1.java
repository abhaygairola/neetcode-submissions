class Solution {
    public int maxArea(int[] heights) {
        int i = 0, j = heights.length-1;
        int maxA = 0;
        while (i < j) {
            int area = (j - i) * Math.min(heights[i], heights[j]);
            maxA = Math.max(maxA, area);
            if (heights[i] < heights[j])
                i++;
            else {
                j--;
            }
        }

        return maxA;
    }
}
