import java.util.*;
public class MaxPathSum {
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
    public static int res(Node root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    /* 
       We used array because of its property of [call by reference]..we will store maximum of the recursive fun and 0
       because if leaf node consists negative value then we don't want to return that and instead we return 0. We keep
       a track of maximum value and return the node value from the path(left or right) which consists the larger value
       as we seek for the maxSum.
     */
    public static int maxPathSum(Node root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], left + right + root.data);
        return Math.max(left, right) + root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println(res(root));
    }   
}