import java.util.*;
public class SubtreeOfTree {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //To check if a tree is subTree of some other tree;
    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        else if (node == null || subRoot == null || subRoot.data != node.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) return false;
        if (!isIdentical(node.right, subRoot.right)) return false;

        return true;
    }
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) return true; 
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static void main(String[] args) {
        /*      1 
        *     /  \
        *   2     3
        *          \
        *           4
        */  
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);

        /*      3
        *        \
        *         4
        */ 

        Node subRoot = new Node(3);
        subRoot.right = new Node(4);

        System.out.println(isSubtree(root, subRoot));
    }
}