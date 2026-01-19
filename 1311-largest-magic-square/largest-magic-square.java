class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rowPrefixSum = new int[rows][cols + 1];
        int[][] colPrefixSum = new int[cols][rows + 1];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rowPrefixSum[r][c + 1] = rowPrefixSum[r][c] + grid[r][c];
                colPrefixSum[c][r + 1] = colPrefixSum[c][r] + grid[r][c];
            }
        }
        for (int size = Math.min(rows, cols); size >= 1; size--) {
            for (int startRow = 0; startRow + size <= rows; startRow++) {
                for (int startCol = 0; startCol + size <= cols; startCol++) {
                    if (isMagicSquare(grid, rowPrefixSum, colPrefixSum, startRow, startCol, size)) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }
    private boolean isMagicSquare(int[][] grid, int[][] rowPrefixSum, int[][] colPrefixSum,
                                  int startRow, int startCol, int size) {
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;
        for (int i = 0; i < size; i++) {
            mainDiagonalSum += grid[startRow + i][startCol + i];
            antiDiagonalSum += grid[startRow + i][startCol + size - 1 - i];
        }

        if (mainDiagonalSum != antiDiagonalSum) return false;
        for (int i = 0; i < size; i++) {
            int currentRowSum = rowPrefixSum[startRow + i][startCol + size] 
                                - rowPrefixSum[startRow + i][startCol];
            if (currentRowSum != mainDiagonalSum) return false;

            int currentColSum = colPrefixSum[startCol + i][startRow + size] 
                                - colPrefixSum[startCol + i][startRow];
            if (currentColSum != mainDiagonalSum) return false;
        }
    return true;
    }
}
