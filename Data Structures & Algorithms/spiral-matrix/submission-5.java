class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int r = matrix.length;
        int c = matrix[0].length;
        int total = r * c;
        int rowStart = 0;
        int rowEnd = r - 1;
        int colStart = 0;
        int colEnd =  c- 1;

        int i = 0 ;
        while (i < total) {
            for (int j = colStart; j <= colEnd && i < total; j++) {
                res.add(matrix[rowStart][j]);
                i++;
            }
            rowStart++;
            for (int j = rowStart; j <= rowEnd && i < total; j++) {
                res.add(matrix[j][colEnd]);
                i++;
            }
            colEnd--;
            for (int j = colEnd; j >= colStart && i < total; j--) {
                res.add(matrix[rowEnd][j]);
                i++;
            }
            rowEnd--;
            for (int j = rowEnd; j >= rowStart && i < total; j--) {
                res.add(matrix[j][colStart]);
                i++;
            }
            colStart++;
        }

        return res;
    }
}