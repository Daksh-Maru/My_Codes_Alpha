import java.util.*;
public class TilingProblem {
    public static int numOfWays(int n) { //n -> floorlength;
        if (n == 0 || n == 1) return 1; 
        //vertical choice
        int fnm1 = numOfWays(n-1);
        //horizontal choice
        int fnm2 = numOfWays(n-2);
        int totWays = fnm1 + fnm2; 
        return totWays;
    }
    public static void main(String[] args) {
        System.out.println(numOfWays(4));
    }
}