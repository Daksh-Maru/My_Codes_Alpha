import java.util.*;
public class FindDuplicateSubtree {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static HashMap<String, Integer> map;
    /* 
        We can create a string the way we want it (like if we want to store some sort of character to 
        null or want it empty) it's just that if the string repeats itself as in the recursive 
        function then mapvalue will increment itself and we can simply print the duplicate string.
    */
    public static String FindSubtree(Node root) {
        if (root == null) {
        return "";
        }
        String subpath = FindSubtree(root.left) + Integer.toString(root.data) + FindSubtree(root.right);

        if (map.get(subpath)!=null && map.get(subpath) == 1) {
            System.out.print(root.data + " ");
        }
        map.put(subpath, map.getOrDefault(subpath, 0) + 1);

        return subpath;
    }
    public static void printAllDups(Node root) {
        map = new HashMap<>();
        FindSubtree(root);
    }
    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);
        printAllDups(root);
    }
}    