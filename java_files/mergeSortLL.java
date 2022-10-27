public class mergeSortLL {
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

    public Node mid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort (Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //Find mid;
        Node mid = mid(head);

        Node rightHead = mid.next;
        mid.next = null;
        
        //Call for left
        Node newLeft = mergeSort(head);
        //Call for right
        Node newRight = mergeSort(rightHead);
        
        return merge(newLeft, newRight);
    }
    public Node merge(Node leftHead, Node rightHead) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (leftHead!=null && rightHead!=null) {
            if (leftHead.data <= rightHead.data) {
                temp.next = leftHead;
                leftHead = leftHead.next;
                temp = temp.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
        }
        while (leftHead!=null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        while (rightHead!=null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
        
        return mergedLL.next;
    }



    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head; 
        head = newNode;
    }

    public void print() { //O(n)
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) { 
        mergeSortLL ll = new mergeSortLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //5->4->3->2->1
        ll.print();
        System.out.println(ll.mid(head).data);
        ll.head = ll.mergeSort(ll.head);
        ll.print();
            
    }
}