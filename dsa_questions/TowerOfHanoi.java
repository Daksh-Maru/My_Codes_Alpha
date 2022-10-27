import java.util.*;
public class TowerOfHanoi {
    public static void hanoiTower(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(" Shift disk " + n + " from " + a + " to " + c);
            return;
        } 
        hanoiTower(n-1, a, c, b);
        System.out.println(" Shift disk " + n + " from " + a + " to " + c);
        hanoiTower(n-1, b, a, c);
    }
    public static void main(String[] args) {
        int n = 3;
        hanoiTower(n, "A", "B", "C");
    }
}