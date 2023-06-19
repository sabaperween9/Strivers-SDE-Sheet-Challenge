import java.io.*;
import java.util.* ;

public class Solution {
    public static void setZeros(int matrix[][]) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int col = 1;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                   if(j == 0) 
                        col = 0;
                   else 
                       matrix[0][j] = 0;
                   matrix[i][0] = 0;
                }
            }
        }

        for(int i = m -1; i > 0; i--) {
            for(int j = n - 1; j > 0; j--) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        for(int i = n-1; i > 0; i--) {
            if(matrix[0][i] == 0 || matrix[0][0] == 0)
                matrix[0][i] = 0;
        }

        if(col == 0) {
            for(int i = m-1; i >= 0; i--) {
                    matrix[i][0] = 0;
            }
        }

    }

}