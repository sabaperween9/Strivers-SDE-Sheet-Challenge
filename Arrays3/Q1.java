class Solution {
// ============================= TC = O(log (m * n))============================================================
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0 , colS = 0 , colE = n - 1;
            while(row < m && colS <= colE) {
                int mid = colS + (colE - colS)/2;
                if(matrix[row][mid] == target)
                    return true;
                else if(matrix[row][mid] < target){
                    if( matrix[row][colE] >= target)
                        colS = mid + 1;
                    else
                        row++;
                }else {
                    if( matrix[row][colS] <= target) 
                        colE = mid - 1;
                    else break;
                }
            }
        return false;
    }
}
