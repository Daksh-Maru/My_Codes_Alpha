public class LinkedList {
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

    //Methods
    // add();
    // remove();
    // print();
    // search();

    public void addFirst(int data) {
        //Step1 = create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //Strep2 = newNode next == head
        newNode.next = head; //link
        //Step3 = newNode
        head = newNode;
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

    public void print() { //O(n)
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if (idx==0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp =  head;
        int i=0;
        while (i<idx-1) {
            temp = temp.next;
            i++;
        }
        //i=idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        } 
        //prev : i = size -2
        Node prev = head;
        for (int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) { //O(n)
        Node temp = head;
        if (temp.data == key) return 0;
        for (int i=1; i<size; i++) {
            temp = temp.next;
            if (temp.data == key) return i;
        }
        return -1;
    }

    public int helper(int key, Node head) {
        if (head == null) return -1;
        if (head.data == key) return 0;
        int idx = helper(key, head.next);
        if (idx == -1) return -1;
        return idx+1;
    } public int recSearch(int key) {
        return helper(key, head);
    }

    public void reverse() { //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        } 
        if (n == sz) {
            head = head.next; //removeFirst
            return;
        }
        int i=1;
        int iToFind= sz-n;
        Node prev = head;
        while (i<iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public Node findMid(Node head) { //helper
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my midNode

    } public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        //step 1 - find mid;
        Node mid = findMid(head);

        //step 2 - reverse 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //step 3 - check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        //detect cycle
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) return;
        
        //find Meeting point
        slow = head;
        Node prev = fast;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;
    }

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev; 
        Node nextL, nextR;
        
        //Alternate Merging - zigZag
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next =nextL;

            left = nextL;
            right = nextR;
        }   
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        // 1->2->3->4->5
        ll.print();
        ll.zigZag();
        ll.print();
        
        // head = new Node(1);
        // Node temp = new Node (2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = head;
        // // 1->2->3->2
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        
        // System.out.println(ll.isPalindrome());
        // ll.deleteNthfromEnd(3);
        // ll.print();

        // ll.reverse();
        // ll.print();
        // System.out.println(ll.removeFirst());
        // ll.print();

        // System.out.println(ll.removeLast());
        // ll.print();

        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(10));

        // System.out.println(ll.recSearch(4));
        // System.out.println(ll.recSearch(10));
        
    }
}
