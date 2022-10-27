import java.util.*;
    public class spiralmatrix {
        public static void main(String []args) {
            int [][]matrix = {{1, 2, 3, 4, 17},
                              {5, 6, 7, 8, 18},
                              {9, 10, 11, 12, 19},
                              {13, 14, 15, 16, 20},
                              {21, 22, 23, 24, 25}};
            
            printspiral(matrix);
        }
        public static void printspiral(int [][]matrix) {
            int rowStart = 0;

            int rowEnd = matrix.length-1;
            int colStart = 0;
            int colEnd = matrix[0].length-1;
            while (rowEnd >= rowStart && colStart <= colEnd) {

                //top 
                for (int i=colStart; i<=colEnd; i++) {
                    System.out.print(matrix[rowStart][i] + " ");
                }
                rowStart++;

                //right
                for (int i=rowStart; i<=rowEnd; i++) {
                    System.out.print(matrix[i][colEnd] + " ");
                }
                colEnd--;

                //bottom
                for (int i=colEnd; i>=colStart; i--) {
                    System.out.print(matrix[rowEnd][i] + " ");
                } 
                rowEnd--;

                //left
                for (int i=rowEnd; i>=rowStart; i--) {
                    System.out.print(matrix[i][colStart] + " ");
                }
                colStart++;
            }
        }
    }