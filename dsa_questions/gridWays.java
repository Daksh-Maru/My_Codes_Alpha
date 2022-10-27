import java.util.*;
public class gridWays {
    public static void main(String[] args) {
        System.out.println(gridWay(0, 0, 5, 5));
    }
    public static int gridWay(int i, int j, int n, int m) {
        if (i == n-1 && j == m-1) return 1;
        else if (i == n || j == m) return 0;

        int w1 = gridWay(i+1, j, n, m);
        int w2 = gridWay(i, j+1, n, m);

        return w1 + w2;
    }
}


/*An alternate trick to find the solution of this problem :-
 * We take D for Down and R for Right;
 * Number of Ds and Rs as a part of string -> n-1 and m-1 repectively;
 * We can print the ways as the combination of Ds are Rs making the string length (n-1+m-1);
 * So number of ways = (n-1+m-1)! / (n-1)! (m-1)! 
 * As I studied in class 11th;
 */