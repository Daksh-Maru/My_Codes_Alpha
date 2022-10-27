import java.util.*;

import javax.management.ListenerNotFoundException;
public class RecursionBasics {
    public static void main(String[] args) {
        String S = "abcab";
        int n = S.length();
        System.out.println(printSubstrs(S, 0, n-1, n));
    }
    public static int printSubstrs(String S, int i, int j, int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        int a = printSubstrs(S, i+1, j, n-1);
        int b = printSubstrs(S, i, j-1, n-1);
        int c = printSubstrs(S, i+1, j-1, n-2);
        int ans = a + b - c;
        if (S.charAt(i) == S.charAt(j)) ans++;
        return ans;
    }

}





    // public static int printFactorial(int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     int fnm1 = printFactorial(n-1);
    //     int fn = n * fnm1;
    //     return fn;
    // }
    // public static int sum(int n) {
    //     if (n == 0) {
    //         return 0;
    //     }
    //     int psum = sum(n-1);
    //     return (psum+n);
    // }
    // public static int Fibo(int n) {
    //     if (n==0 || n==1) {
    //         return n;
    //     } 
    //     int pfibo = Fibo(n-1);
    //     int ppfibo = Fibo(n-2);
    //     int nfibo = pfibo + ppfibo;
    //     return nfibo;
    // }

    // public static boolean checkSort(int[] n, int i) {
    //     if (i == n.length-1) return true;
    //     if (n[i] > n[i+1]) return false;        
    //     return checkSort(n, i+1);
    // }

    // public static int fOccur(int[] n, int i, int x) {
    //     if (i == n.length) return -1; 
    //     if (n[i] == x) return i;
    //     return fOccur(n, i+1, x);
    // }

    // public static int lOccur(int[]n, int i, int x) {
    //    if (i == n.length) return -1;
    //    int isFound = lOccur(n, i+1, x);
    //    if (isFound == -1 && n[i] == x) return i;
    //    return isFound;
    // }

    // public static int xpowern (int x, int n) {
    //     if (n == 1) return x;
    //     int halfp = xpowern(x, n/2);
    //     int halfpsq = halfp * halfp;
    //     if (n % 2 != 0) halfpsq *= x;
    //     return halfpsq;
    // }
    


    
    // int[] n = {1, 2, 8, 3, 8, 5};
    // System.out.println(printFactorial(n));
    // System.out.println(sum(n)); 
    // System.out.println(Fibo(n)); 
    // System.out.println(checkSort(n, 0));
    // System.out.println(fOccur(n, 0, 2))
    // System.out.println(lOccur(n, 0, 5));
    // System.out.println(xpowern(2, 10));