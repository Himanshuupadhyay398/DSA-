class Solution {
    public int minDeletionSize(String[] strs) {

        int totalRows = strs.length;
        int totalCols = strs[0].length();
        int deletedColumns = 0;
        boolean[] isSorted = new boolean[totalRows - 1];

        for (int col = 0; col < totalCols; col++) {
            boolean shouldDelete = false;
            for (int row = 0; row < totalRows - 1; row++) {
                if (!isSorted[row] &&
                    strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    shouldDelete = true;
                    break;
                }
            }
            if (shouldDelete) {
                deletedColumns++;
            } else {
                for (int row = 0; row < totalRows - 1; row++) {
                    if (!isSorted[row] &&
                        strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                        isSorted[row] = true;
                    }
                }
            }
        }
    return deletedColumns;
    }
}
