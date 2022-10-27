import java.util.*;
public class MirrorBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
    
        root = mirror(root);
        preOrder(root);
    }
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node mirror(Node root) {
        if (root == null) return null;

        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}