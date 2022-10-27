import java.util.*;
public class WordBreakProblem {
    public static void main(String[] args) {
        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        for (int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }

        System.out.println(wordBreak(key));
    }
    //To find if key can be broken into substrings and fit in arr
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i=1; i<=key.length(); i++) {
            if (Search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    
    
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;  //End Of Word
        Node() {
            for (int i=0; i<26; i++)  {
                children[i] = null;
            }
        }
    }
    public static Node root =  new Node();
    //Inserting character nodes in the Trie
    public static void insert(String word) {
        Node curr = root;
        for (int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    //Searching for the word in the Trie
    public static boolean Search(String key) {
        Node curr = root;
        for (int level = 0; level<key.length(); level++) {
            int idx = key.charAt(level)-'a';
            if (curr.children[idx] == null) {
                return false;
            }  

            curr = curr.children[idx];
        }
        return curr.eow==true;
    }
}