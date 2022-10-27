import java.util.*;
public class FriendsPairing {
    public static void main(String[] args) {
        System.out.println(pairFriends(3)); 
    }
    public static int pairFriends(int n) {
        if (n == 1 || n == 2) return n;
        int singleWays = pairFriends(n-1);
        int doubleWays = pairFriends(n-2) * (n-1);
        int totWays = singleWays + doubleWays;
        return totWays;
    }
}