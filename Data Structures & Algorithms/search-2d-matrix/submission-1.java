class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = 0;
        int high = r * c - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            int mr = mid / c, mc = mid % c;
            if (target > matrix[mr][mc]) {
                low = mid + 1;
            } else if (target < matrix[mr][mc]) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
