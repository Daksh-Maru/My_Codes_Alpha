
public class LinkedListtwo {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // private Node intersectionP(Node head1, Node head2) {
    //     while (head1 !=null) {
    //         Node temp = head2;
    //         while (temp != null) {
    //             if (temp == head1) {
    //                 return head1;
    //             } 
    //             temp = temp.next;
    //         }
    //         head1 = head1.next;
    //     }
    //     return null;
    // }
    public void displayM(int M, int N) {
        int countM = 1;
        int countN = 1;
        Node temp = head;
        Node temp2;
        while (temp != null) {
            while (countM<M) {
                temp = temp.next;
                countM++;
            }
            temp2 = temp.next;
            while (countN<N) {
                temp2 = temp2.next;
                size--;
                countN++;
            }
            temp = temp.next = temp2.next;
            countM = 1;
            countN = 1;
        }

    }

    public void print() { //O(n)
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    
    public static void main(String[] args) {
        LinkedListtwo ll = new LinkedListtwo();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.print();
        ll.displayM(3, 2);
        ll.print();

    }
}