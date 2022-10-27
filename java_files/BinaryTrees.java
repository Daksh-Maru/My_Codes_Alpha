import java.util.*;
public class BinaryTrees {
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

    public static int height(Node root) {
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

public static int count(Node root) {
        if (root == null) return 0;
        
        int lc = count(root.left);
        int rc = count(root.right);
        
        return lc + rc +1;
    }

    public static int nodeSum(Node root) {
        if (root == null) return 0;

        int lsum = nodeSum(root.left);
        int rsum = nodeSum(root.right);

        return lsum + rsum + root.data;
    }

    //Approach #1
    public static int treeDiameter(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        int diam = lh + rh + 1;

        int Ldiam  = treeDiameter(root.left);
        int Rdiam = treeDiameter(root.right);

        return Math.max(Math.max(Ldiam, Rdiam), diam);
    } 
    //Approach #2 
    static class Info {
        int diam;
        int ht;
        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info treediameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info lInfo = treediameter(root.left);
        Info rInfo = treediameter(root.right);

        int diam = Math.max(Math.max(lInfo.diam, rInfo.diam), lInfo.ht+rInfo.ht+1);
        int ht = Math.max(lInfo.ht, rInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(0);
        root.left.left.left.left = new Node(11);
        root.left.right = new Node(5);
        root.left.right.right = new Node(10);
        root.left.right.right.right = new Node(12);

        // System.out.println(nodeSum(root));
        // System.out.println(count(root));
        // System.out.println("Diameter of the tree is : " + treeDiameter(root));
        System.out.println("Diameter of the tree is : " + treediameter(root).diam);
    }
}