import java.util.*;

import javax.print.event.PrintEvent;
public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = { {1, 0, 0, 0},
                         {1, 1, 0, 1},
                         {0, 1, 0, 0},
                         {1, 1, 1, 1} };

        int[][] sol = new int [maze.length][maze.length];
        for (int i=0; i<sol.length; i++) {
            for (int j=0; j<sol.length; j++) {
                sol[i][j] = 0;
            }
        }

        if (solMaze(maze, 0, 0, sol)) {
            System.out.println("Solution exists");
            printSol(sol);
        } else {
            System.out.println("Solution doesnot exists");
        }
    }
    public static void printSol(int[][] sol) {
        for (int i=0; i<sol.length; i++) {
            for (int j=0; j<sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int[][] maze, int x, int y) {
        return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);
    }
    public static boolean solMaze(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;
        //Base Case
        if (x == n-1 && y == n-1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        //Recursive Function
        if (isSafe(maze, x, y)) {
            if (sol[x][y] == 1) return false;
            sol[x][y] = 1;
            if (solMaze(maze, x+1, y, sol)) return true;
            if (solMaze(maze, x, y+1, sol)) return true;
            sol[x][y] = 0;
        }
        return false;
    }
    
}