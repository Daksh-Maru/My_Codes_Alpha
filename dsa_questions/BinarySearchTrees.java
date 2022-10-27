import java.util.*;
public class BinarySearchTrees {
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;
        for (int i=0 ;i<values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        // root = deleteNode(root, 1);
        // inOrder(root);
        // printRoot2Leaf(root, new ArrayList<>());
        // printInRange(root, 10, 14);
        System.out.println(isValidBST(root, null, null));
    }
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }
    }
    //inOrder Traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    //Build A BSt    
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    //Search in BST
    public static boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return Search(root.left, key);
        } else {
            return Search(root.right, key);
        }
    }
    //Delete Node from BST
    public static Node deleteNode(Node root, int val) {
        if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    } public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    } 

    //Root to Leaf Path
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);

        path.remove(path.size()-1);

    } public static void printPath(ArrayList<Integer> path) {
        for (int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println("Null");
    }
    //Print in Range of the two numbers
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        } 
    }

    //Check the validity of the BST
    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) return true;

        if ((min!=null && root.data <= min.data) || (max!=null && root.data >= max.data)) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    
}