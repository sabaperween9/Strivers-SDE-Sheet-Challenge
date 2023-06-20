class Solution {
// ====================================== TC = (n^2) ============================================================
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) 
                swap(matrix, i, j);
        }

        int colS = 0 , colE = n - 1;
        while(colS < colE) {
            for(int i = 0; i < n; i++) {
                int temp = matrix[i][colS];
                matrix[i][colS] = matrix[i][colE];
                matrix[i][colE] = temp;
            }
            colS++;
            colE--;
        } 

    }

    void swap(int[][] matrix , int i , int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
