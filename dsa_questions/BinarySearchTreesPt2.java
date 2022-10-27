import java.util.*;
public class BinarySearchTreesPt2 {
    public static void main(String[] args) {
        //This BST is to be converted to a balanced BST
        Node root = new Node(8);
        root.left = new Node(6);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.right.right.right = new Node(12);

        root = balancedBST(root);
        preOrder(root);
    }
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            Node left = right = null;
        }
    }
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }
    /*  
        This also covers that the part --> Array to Balanced BST as in this question we first convert
        inbalanced BST to ArrayList and then to balanced BST.
    */
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st>end) {
            return null;
        } 
        int mid = st + (end-st)/2;
        Node root = new Node(inorder.get(mid));

        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);

        return root;
    }
    public static Node balancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        root = createBST( inorder, 0, inorder.size()-1);
        return root;
    }
}