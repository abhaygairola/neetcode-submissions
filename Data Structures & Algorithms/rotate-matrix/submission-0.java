class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // reverse verically

        for (int i = 0; i < r / 2; i++) {
            for (int j = 0; j < c; j++) {
                swap(matrix, i, j, r - i - 1, j);
            }
        }

        // transpose
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j,i);
            }
        }
    }
    private void swap(int[][] a, int r1, int c1, int r2, int c2) {
        int temp = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = temp;
    }
}
