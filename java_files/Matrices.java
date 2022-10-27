import java.util.*;
    public class Matrices {
        public static void main(String []args) {
            int [][]matrix = {{1, 2, 3,},
                              {5, 6, 7,},
                              {9, 10, 11,}};
            int key;
            searchkey(matrix);
        }
        public static void diagonalSum(int [][]matrix) {
            int pSum = 0;
            int sSum = 0;
            for (int i=0; i<matrix.length; i++) {
                pSum += matrix[i][i];
                if (i != matrix.length-1-i){
                    sSum += matrix[i][matrix.length-i-1];
                }
            }
            System.out.println("Sum of values in primary D : " + pSum);
            System.out.println("Sum of values in secondary D : " + sSum);
            System.out.println("Total : " + (pSum+sSum));
        }

        public static void searchkey(int [][]matrix, int key) {
            int r = matrix.length - 1;
            int c = 0;
               while (r>=0  && c<matrix[0].length) {
                    if (matrix[r][c] == key) {
                        System.out.println("The key is found at : " + i + "," + mid);
                    }
                    else if (matrix[r][c] < key) {
                        r--;
                    }
                    else {
                        c++;
                    }
                }
            
        }
    }