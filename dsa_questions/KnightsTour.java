import java.util.*;

import javax.print.URIException;
public class KnightsTour {
    public static void main(String[] args) {
        int N = 8;
        int[][] sol = new int [N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sol[i][j] = -1;
            }
        }

        sol[0][0] = 0; 

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        if (solution(N, 0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Soution exists");
            printTour(sol, N);
        } else {
            System.out.println("Solution does not exists");
        }
    }

    public static boolean solution(int N, int x, int y, int count, int[][] sol, int[] xMove, int[] yMove) {
        int nextX, nextY;
        if (count == N*N) return true;
        for (int k=0; k<8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(N, nextX, nextY, sol)) {
                sol[nextX][nextY] = count;
                if (solution(N, nextX, nextY, count+1, sol, xMove, yMove)){
                    return true;
                } 
                else {
                    sol[nextX][nextY] = -1;
                } 
            }
        }
        return false;
    }

    public static boolean isSafe(int N, int x, int y, int[][] sol) {
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }

    public static void printTour(int[][] sol, int N) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(sol[i][j] + "  ");
            }
            System.out.println();
        }
    }
}