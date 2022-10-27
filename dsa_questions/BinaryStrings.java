import java.util.*;
public class BinaryStrings {
    public static void main(String[] args) {
        printBS(4, 0, "");
    }
    public static void printBS(int n, int lastPlace, String str) {
        if (n == 0) { 
            System.out.println(str);
            return;
        } 
        printBS(n-1, 0, str+"0");
        if (lastPlace == 0) {
            printBS(n-1, 1, str+"1");
        }   
    }
}