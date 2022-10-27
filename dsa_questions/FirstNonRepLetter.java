import java.util.*;

public class FirstNonRepLetter {
    public static void printNonRepeating(String str) {
        int freq[] = new int [26];
        Queue<Character> q = new LinkedList<>();

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            } 
            if ((!q.isEmpty()) && (freq[q.peek()-'a'] == 1)) {
                System.out.print(q.peek() + " ");
            } else {
                System.out.print(-1 + " " );
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}